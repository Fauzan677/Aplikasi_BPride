package com.example.b_pride.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.b_pride.Login.ForgotPassword
import com.example.b_pride.Login.RegisterPage
import com.example.b_pride.R
import com.example.b_pride.nav.navigation


class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val lupa = findViewById<TextView>(R.id.lupa)
        lupa.setOnClickListener {
            val Intent = Intent(this, ForgotPassword::class.java)
            startActivity(Intent)
        }

        val daftar = findViewById<TextView>(R.id.daftar)
        daftar.setOnClickListener {
            val Intent = Intent(this, RegisterPage::class.java)
            startActivity(Intent)
        }

        val masuk : Button = findViewById(R.id.masuk)
        masuk.setOnClickListener {
            val intent = Intent(this, navigation :: class.java)
            startActivity(intent)
        }

    }
}