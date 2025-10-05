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
            val phone = binding.etPhone.text.toString()
            val fullNumber=binding.ccp.selectedCountryCode+phone

            val users = sharedPref.getStringSet("users", mutableSetOf())
            if (phone.isNotEmpty()&& binding.etPassword.text.toString().isNotEmpty()) {
            if (users != null && users.contains(fullNumber)) {
                Toast.makeText(this, "تم تسجيل الدخول بنجاح ", Toast.LENGTH_SHORT).show()
                sharedPref.edit()
                    .putBoolean("isLoggedIn", true)
                    .apply()

                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "لا يوجد حساب الرجاء انشاء حساب اولا", Toast.LENGTH_SHORT).show()
            }
        }else {
                Toast.makeText(this, "ادخل رقم الهاتف و كلمة المرور", Toast.LENGTH_SHORT).show()

            }}

        binding.createAccount.setOnClickListener { startActivity(
            Intent(
                this,
                SignUpActivity::class.java
            )
        ) }


    }
}