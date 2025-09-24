package com.example.onboarding.presentaion.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onboarding.presentaion.activity.MainActivity
import com.example.onboarding.databinding.FragmentThirdBinding


class Fragment3 : Fragment() {


    private lateinit var  binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)

        binding.bnNext.setOnClickListener {
            (activity as MainActivity).nextPage()
        }

        binding.bnSkip.setOnClickListener {
            (activity as MainActivity).skipToEnd()
        }

        return binding.root

    }
}
