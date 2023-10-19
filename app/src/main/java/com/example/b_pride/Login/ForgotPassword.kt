package com.example.b_pride.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.b_pride.databinding.ActivityForgotPasswordBinding
import com.example.b_pride.login.LoginPage

class ForgotPassword : AppCompatActivity() {

    private lateinit var binding : ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this, LoginPage ::class.java))

        }
    }
}