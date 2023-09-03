package com.example.b_pride.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.b_pride.R

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        var kirim = findViewById<Button>(R.id.button)
        kirim.setOnClickListener {
            var intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }
}