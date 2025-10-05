package com.example.onboarding.presentaion.activity

import HomeFragment
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onboarding.R
import com.example.onboarding.databinding.ActivityNotificationBinding
import com.example.onboarding.presentaion.Adapters.NotificationAdapter
import com.example.onboarding.presentaion.Data.SharedPrefrence

class NotificationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val adapterNotificationCard = NotificationAdapter{
            SharedPrefrence.setNotificationsRead(this, true)
                    finish ()}


        binding.recyclerNotification.apply {
            layoutManager =
                LinearLayoutManager(this@NotificationActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = adapterNotificationCard

        }

        binding.btnBack.setOnClickListener { startActivity(Intent(this,HomeFragment::class.java)) }

    }
}