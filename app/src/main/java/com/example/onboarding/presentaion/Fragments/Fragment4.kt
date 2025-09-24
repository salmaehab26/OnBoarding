package com.example.onboarding.presentaion.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onboarding.presentaion.activity.MainActivity
import com.example.onboarding.databinding.FragmentFourthBinding


class Fragment4 : Fragment() {


    private lateinit var  binding: FragmentFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthBinding.inflate(inflater, container, false)

        binding.bnNext.setOnClickListener {
            (activity as MainActivity).lastFragment()
        }

        return binding.root
    }


}