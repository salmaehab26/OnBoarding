package com.example.onboarding.presentaion.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
            val phone = binding.etPhone.text.toString()
            val fullNumber=binding.ccp.selectedCountryCode+phone
            if (phone.isNotEmpty()&&binding.etName.text.toString().isNotEmpty()&&binding.etEmail.text.toString().isNotEmpty()) {
                val users = sharedPref.getStringSet("users", mutableSetOf())!!.toMutableSet()
                users.add(fullNumber)
                sharedPref.edit().putStringSet("users", users).apply()

                Toast.makeText(this, "User Registered $fullNumber ", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }}
        binding.btnBack.setOnClickListener {  startActivity(Intent(this, LogInActivity::class.java))
        }

    }
}