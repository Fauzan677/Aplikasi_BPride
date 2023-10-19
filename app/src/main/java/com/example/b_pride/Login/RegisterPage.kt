package com.example.b_pride.Login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.b_pride.data.AppDatabase
import com.example.b_pride.data.User
import com.example.b_pride.databinding.ActivityRegisterPageBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterPage : AppCompatActivity() {
    private lateinit var appDb : AppDatabase

    private lateinit var binding : ActivityRegisterPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDb = AppDatabase.getDatabase(this)
        binding.button.setOnClickListener {
            writeData()
        }


    }

    private fun writeData(){

        val name = binding.username.text.toString()
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        if(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()     ) {
            val user = User(
                null, name, email, password
            )
            GlobalScope.launch(Dispatchers.IO) {

                appDb.userDao().insert(user)
            }

            binding.username.text.clear()
            binding.email.text.clear()
            binding.password.text.clear()

            Toast.makeText(this,"Successfully written", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this,"PLease Enter Data", Toast.LENGTH_SHORT).show()
        }


    }
}