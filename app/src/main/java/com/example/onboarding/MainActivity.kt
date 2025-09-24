package com.example.onboarding

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.onboarding.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dotsContainer: LinearLayout
    private var currentIndex = 0

    private val dots = mutableListOf<ImageView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge ()
        binding = ActivityMainBinding.inflate (layoutInflater)
        setContentView (binding.root)

        dotsContainer = binding.dotsContainer

        showFragment(0)

        createDots(FragmentsList.allFragments.size)
        setCurrentDot(0)
    }

    private fun showFragment(index: Int) {
        currentIndex = index
        val fragment: Fragment = FragmentsList.allFragments[index]
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()

        setCurrentDot(index)
    }

    fun nextPage() {
        val nextIndex = currentIndex + 1
        if (nextIndex < FragmentsList.allFragments.size) {
            showFragment(nextIndex)
        } else {
            lastFragment()
        }
    }


    fun skipToEnd() {
        showFragment(FragmentsList.allFragments.size - 1)
    }

    fun lastFragment() {
        Snackbar.make(binding.root, "Finish ", Snackbar.LENGTH_LONG).show()
    }

    private fun createDots(count: Int) {
        dots.clear()
        dotsContainer.removeAllViews()

        for (i in 0 until count) {
            val dot = ImageView(this).apply {
                val size = LinearLayout.LayoutParams(20, 20)
                size.setMargins(8, 0, 8, 0)
                layoutParams = size
                setImageResource(R.drawable.dot_unselected)
            }
            dots.add(dot)
            dotsContainer.addView(dot)
        }
    }

    private fun setCurrentDot(index: Int) {
        for (i in dots.indices) {
            val res = if (i == index) R.drawable.dot_selected else R.drawable.dot_unselected
            dots[i].setImageResource(res)
        }
    }
}