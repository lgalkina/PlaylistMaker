package com.practicum.playlistmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        createSettingsBackButton()
    }

    private fun createSettingsBackButton() {
        val imageView = findViewById<ImageView>(R.id.settings_back)
        imageView.setOnClickListener {
            finish()
        }
    }
}