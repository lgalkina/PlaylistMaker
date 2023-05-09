package com.practicum.playlistmaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setUpDarkThemeButton()
        setUpBackButton()
        setUpShareButton()
        setUpSettingsSupportButton()
        setUpUserAgreementButton()
    }

    private fun setUpBackButton() {
        val imageView = findViewById<ImageView>(R.id.settings_back)
        imageView.setOnClickListener {
            finish()
        }
    }

    private fun setUpDarkThemeButton() {
        val switch = findViewById<SwitchCompat>(R.id.dark_theme)
        val clickListener: View.OnClickListener = View.OnClickListener {
            if (switch.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }
        switch.setOnClickListener(clickListener)
    }

    private fun setUpShareButton() {
        val view = findViewById<TextView>(R.id.share)
        val clickListener: View.OnClickListener = View.OnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.yandex_practicum_android_course_url))
            startActivity(intent)
        }
        view.setOnClickListener(clickListener)
    }

    private fun setUpSettingsSupportButton() {
        val view = findViewById<TextView>(R.id.support)
        val clickListener: View.OnClickListener = View.OnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.support_email)))
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.support_email_subject))
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.support_email_text))
            startActivity(intent)
        }
        view.setOnClickListener(clickListener)
    }

    private fun setUpUserAgreementButton() {
        val view = findViewById<TextView>(R.id.user_agreement)
        val clickListener: View.OnClickListener = View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.yandex_practicum_offer_url)))
            startActivity(intent)
        }
        view.setOnClickListener(clickListener)
    }
}