package com.createsapp.languagedemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEnglish.setOnClickListener {
            setAppLocale(this,"en")
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }

        btnHindi.setOnClickListener {
            setAppLocale(this,"hi")
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)
        }

    }

    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }

}