package com.example.onboarding.presentaion.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.onboarding.R
import com.example.onboarding.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var  binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("sharedPreference", MODE_PRIVATE)
        val isFirstTime = sharedPref.getBoolean("isFirstTime", true)
        Handler(Looper.getMainLooper()).postDelayed(
                    {
        if (isFirstTime) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, LogInActivity::class.java))
        }

        finish()
            }, 3000
        )
        Log.d("Splash","finish")
    }
}