package com.example.wordsfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.wordsfactory.onboard.OnboardActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val i = Intent(this@SplashScreenActivity, OnboardActivity::class.java)
            startActivity(i)
            finish()
        }, 2000)
    }
}