package com.example.onboarding.presentaion.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.onboarding.R
import com.example.onboarding.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("sharedPreference", MODE_PRIVATE)
        binding.bnSignIn.setOnClickListener {
            val phoneNumber =sharedPref.getString("phoneNubmer",null)

            if (phoneNumber != null) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "No account found! Please Sign Up first.", Toast.LENGTH_SHORT).show()
            }

        }

        binding.createAccount.setOnClickListener { startActivity(
            Intent(
                this,
                SignUpActivity::class.java
            )
        ) }


    }
}