package com.example.onboarding.presentaion.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.onboarding.R
import com.example.onboarding.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val emojis = listOf(
        R.drawable.emoji_happy,
        R.drawable.emoji_angry,
        R.drawable.emoji_enthusiastic,
        R.drawable.emoji_exhausted,
        R.drawable.emoji_anxious,
        R.drawable.emoji_sad
    )

    private var currentIndex = 0

    private val handler = Handler(Looper.getMainLooper())
    private lateinit var emojiRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        navigationBar()

        binding.moodEmoji.setImageResource(emojis[currentIndex])

        binding.ivClose.setOnClickListener {
            binding.moodBar.visibility = View.GONE
        }

        emojiRunnable = object : Runnable {
            override fun run() {
                animateEmojiChange()
                handler.postDelayed(this, 2000)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        handler.post(emojiRunnable)
    }







    private fun animateEmojiChange() {
        val slideOut = AnimationUtils.loadAnimation(this, R.anim.slide_out_up)
        val slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_up)

        slideOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) { }
            override fun onAnimationRepeat(animation: Animation?) { }
            override fun onAnimationEnd(animation: Animation?) {
                currentIndex = (currentIndex + 1) % emojis.size
                binding.moodEmoji.setImageResource(emojis[currentIndex])

                binding.moodEmoji.startAnimation(slideIn)
            }
        })

        binding.moodEmoji.startAnimation(slideOut)
    }

    private fun navigationBar() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNav.setupWithNavController(navController)
    }
}
