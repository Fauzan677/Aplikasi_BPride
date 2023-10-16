package com.example.b_pride.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.b_pride.databinding.ActivityRegisterPageBinding

class RegisterPage : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            startActivity(Intent(this, LoginPage::class.java))

        }
    }
}