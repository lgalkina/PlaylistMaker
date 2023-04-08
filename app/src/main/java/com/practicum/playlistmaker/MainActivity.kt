package com.practicum.playlistmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createSearchButton()
        createMediaLibraryButton()
        createSettingsButton()
    }

    private fun createSearchButton() {
        val button = findViewById<Button>(R.id.search)
        val clickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, SearchActivity::class.java)
                startActivity(intent)
            }
        }
        button.setOnClickListener(clickListener)
    }

    private fun createMediaLibraryButton() {
        val button = findViewById<Button>(R.id.media_library)
        button.setOnClickListener {
            val intent = Intent(this, MediaLibraryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createSettingsButton() {
        val button = findViewById<Button>(R.id.settings)
        button.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}