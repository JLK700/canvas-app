package com.example.druggame.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.druggame.R
import com.example.druggame.databinding.LandingFragmentBinding


class LandingFragment : Fragment() {

    private lateinit var binding: LandingFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.landing_fragment, container, false)

        binding.buttonFirst.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_LandingFragment_to_designFragment)
        }
        return binding.root
    }

}