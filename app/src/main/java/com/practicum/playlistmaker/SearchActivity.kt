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

class SearchActivity : AppCompatActivity() {

    companion object {
        const val SEARCH_TEXT = "SEARCH_TEXT"
    }

    var currentSearchText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        createBackButton()
        createSearchEditText()
        createSearchClearButton()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SEARCH_TEXT, currentSearchText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val editText = findViewById<EditText>(R.id.search_edit_text)
        editText.setText(savedInstanceState.getString(SEARCH_TEXT,""))
    }

    private fun createBackButton() {
        val imageView = findViewById<ImageView>(R.id.search_back)
        imageView.setOnClickListener {
            finish()
        }
    }

    private fun createSearchEditText() {
        val searchEditText = findViewById<EditText>(R.id.search_edit_text)
        val clearSearchButton = findViewById<ImageView>(R.id.search_clear)
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

    private fun createSearchClearButton() {
        val clearSearchButton = findViewById<ImageView>(R.id.search_clear)
        val searchEditText = findViewById<EditText>(R.id.search_edit_text)
        val clickListener: View.OnClickListener = View.OnClickListener {
            searchEditText.text.clear()
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(searchEditText.windowToken, 0)
        }
        clearSearchButton.setOnClickListener(clickListener)
    }
}