package com.example.onboarding.presentaion.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.onboarding.presentaion.Fragments.FragmentsList
import com.example.onboarding.R
import com.example.onboarding.presentaion.Adapters.ViewPagerAdapter
import com.example.onboarding.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dotsContainer: LinearLayout
    private val dots = mutableListOf<ImageView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dotsContainer = binding.dotsContainer
        createDots(FragmentsList.allFragments.size)
        setCurrentDot(0)
        buttonsAction()
        viewPager()
    }

    fun viewPager(){
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(this, FragmentsList.allFragments)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            setCurrentDot(position)
            buttonsVisibility(position)
        }
    })}
    private fun createDots(count: Int) {
        dots.clear()
        dotsContainer.removeAllViews()
        for (i in 0 until count) {
            val dot = ImageView(this).apply {
                val size = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                size.setMargins(8, 0, 8, 0)
                layoutParams = size
                setImageResource(R.drawable.dot_unselected)
            }
            dots.add(dot)
            dotsContainer.addView(dot)
        }
    }

    fun buttonsVisibility(position: Int) {
        if (position == FragmentsList.allFragments.size - 1) {
            binding.bnNext.visibility = View.GONE
            binding.bnSkip.visibility = View.GONE
            binding.bnSignIn.visibility = View.VISIBLE
        } else {
            binding.bnNext.visibility = View.VISIBLE
            binding.bnSkip.visibility = View.VISIBLE
            binding.bnSignIn.visibility = View.GONE
        }
    }

    fun nextPage() {
        val nextIndex = binding.viewPager.currentItem + 1
            binding.viewPager.currentItem = nextIndex
    }

    private fun setCurrentDot(index: Int) {
        for (i in dots.indices) {
            val res = if (i == index) R.drawable.dot_selected
            else R.drawable.dot_unselected
            dots[i].setImageResource(res)
        }
    }

    fun buttonsAction() {
        binding.bnNext.setOnClickListener {
            nextPage()
        }

        binding.bnSkip.setOnClickListener {
            skipToEnd()
        }
        binding.bnSignIn.setOnClickListener {
            lastFragment()
        }
    }

    fun skipToEnd() {
        binding.viewPager.currentItem = FragmentsList.allFragments.size - 1
    }

    fun lastFragment() {
        Snackbar.make(binding.root, "Finish", Snackbar.LENGTH_LONG).show()
    }
}