package com.example.onboarding.presentaion.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.onboarding.R
import com.example.onboarding.databinding.ActivitySignUpBinding
import androidx.core.content.edit

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("sharedPreference", MODE_PRIVATE)

        binding.bnSignIn.setOnClickListener {
            sharedPref.edit {
                putString("phoneNumber", binding.etPhone.text.toString())
                apply()

            }
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.btnBack.setOnClickListener {  startActivity(Intent(this, LogInActivity::class.java))
        }

    }
}