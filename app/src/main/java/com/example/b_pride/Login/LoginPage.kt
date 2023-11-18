package com.example.b_pride.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.b_pride.Login.ForgotPassword
import com.example.b_pride.Login.RegisterPage
import com.example.b_pride.R
import com.example.b_pride.data.lokal.AppDatabase
import com.example.b_pride.data.lokal.User
import com.example.b_pride.databinding.ActivityLoginPageBinding
import com.example.b_pride.databinding.ActivityRegisterPageBinding
import com.example.b_pride.nav.navigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginPage : AppCompatActivity() {
    private lateinit var appDb : AppDatabase
    private lateinit var binding : ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDb = AppDatabase.getDatabase(this)

        binding.lupa.setOnClickListener {
            val Intent = Intent(this, ForgotPassword::class.java)
            startActivity(Intent)
        }

        binding.daftar.setOnClickListener {
            val Intent = Intent(this, RegisterPage::class.java)
            startActivity(Intent)
        }

        binding.masuk.setOnClickListener {
            val name = binding.username.text.toString()
            val password = binding.password.text.toString()

            if(name.isNotEmpty() && password.isNotEmpty()) {
                readData(name, password)
            } else {
                Toast.makeText(this,"Isi semua field", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun readData(name: String, pass: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                lateinit var user: User
                user = appDb.userDao().getNamePass(name, pass)
                Log.d("Data", user.toString())
                withContext(Dispatchers.Main) {
                    verifikasi(user, name, pass)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoginPage, "Username / Password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun verifikasi(user: User, name: String, pass: String) {
        if(user.firstName == name && user.password == pass) {
            val intent = Intent(this, navigation::class.java)
            startActivity(intent)
        }
    }
}