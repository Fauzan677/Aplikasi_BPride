package com.example.b_pride.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.b_pride.R

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        var daftar = findViewById<Button>(R.id.button)
        daftar.setOnClickListener {
            var intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }
}