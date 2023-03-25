package com.practicum.playlistmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        createSettingsBackButton()
    }

    private fun createSettingsBackButton() {
        val button = findViewById<Button>(R.id.settings_back)
        button.setOnClickListener {
            finish()
        }
    }
}