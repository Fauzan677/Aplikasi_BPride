package com.example.b_pride.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.b_pride.R
import com.example.b_pride.login.LoginPage

class SplashScreen : AppCompatActivity() {

    private lateinit var gambar_loading: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        gambar_loading = findViewById(R.id.apple)

        setAnimation()
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }, 2000)
    }

    private fun setAnimation(){
        val animaiton = AnimationUtils.loadAnimation(
            this@SplashScreen,
            R.anim.anim)
        gambar_loading.animation = animaiton
    }
}