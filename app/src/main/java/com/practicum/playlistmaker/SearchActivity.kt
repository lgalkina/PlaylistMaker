package com.practicum.playlistmaker

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.practicum.playlistmaker.track.TracksAdapter
import com.practicum.playlistmaker.track.getTracksMockData

class SearchActivity : AppCompatActivity() {

    private companion object {
        const val SEARCH_TEXT = "SEARCH_TEXT"
    }

    private var currentSearchText = ""
    private lateinit var searchEditText: EditText
    private lateinit var clearSearchButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchEditText = findViewById(R.id.search_edit_text)
        clearSearchButton = findViewById(R.id.search_clear)

        setUpBackButton()
        setUpSearchEditText()
        setUpSearchClearButton()
        setUpSearchRecyclerView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SEARCH_TEXT, currentSearchText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        searchEditText.setText(savedInstanceState.getString(SEARCH_TEXT,""))
    }

    private fun setUpBackButton() {
        val imageView = findViewById<ImageView>(R.id.search_back)
        imageView.setOnClickListener {
            finish()
        }
    }

    private fun setUpSearchEditText() {
        searchEditText.requestFocus()
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()) {
                    clearSearchButton.visibility = View.GONE
                } else {
                    clearSearchButton.visibility = View.VISIBLE
                }
                currentSearchText = searchEditText.text.toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        searchEditText.addTextChangedListener(textWatcher)
    }

    private fun setUpSearchClearButton() {
        val clickListener: View.OnClickListener = View.OnClickListener {
            searchEditText.text.clear()
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(searchEditText.windowToken, 0)
        }
        clearSearchButton.setOnClickListener(clickListener)
    }

    private fun setUpSearchRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.search_recyclerView)
        val tracksAdapter = TracksAdapter(getTracksMockData())
        recyclerView.adapter = tracksAdapter
    }
}