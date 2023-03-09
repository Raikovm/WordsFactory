package com.example.wordsfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.wordsfactory.onboard.OnboardActivity
import com.google.android.material.textfield.TextInputEditText

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()
        findViewById<Button>(R.id.buttonSignup).setOnClickListener {
            if (fieldsNotEmpty()) {
                startActivity(Intent(this@SignupActivity, MainActivity::class.java))
                finish()
                return@setOnClickListener
            }

            AlertDialog.Builder(this)
                .setTitle(getString(R.string.loginFail))
                .setMessage(R.string.loginFailEmpty)
                .show()
        }

        findViewById<Button>(R.id.buttonBack).setOnClickListener {
            startActivity(Intent(this@SignupActivity, OnboardActivity::class.java))
            finish()
        }
    }

    private fun fieldsNotEmpty(): Boolean {
        val name = findViewById<TextInputEditText>(R.id.signup_input_name)
        val email = findViewById<TextInputEditText>(R.id.signup_input_email)
        val password = findViewById<TextInputEditText>(R.id.signup_input_password)
        return (name.text.toString().isNotEmpty() &&
                email.text.toString().isNotEmpty() &&
                password.text.toString().isNotEmpty())
    }
}