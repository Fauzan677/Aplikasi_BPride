package com.example.b_pride.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.b_pride.MainActivity
import com.example.b_pride.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {

    private lateinit var binding : ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.lupa.setOnClickListener {
            var Intent = Intent(this, ForgotPassword::class.java)
            startActivity(Intent)
        }

        binding.daftar.setOnClickListener {
            startActivity(Intent(this, RegisterPage::class.java))
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}