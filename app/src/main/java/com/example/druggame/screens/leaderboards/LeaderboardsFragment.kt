package com.example.druggame.screens.leaderboards

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.druggame.R

class LeaderboardsFragment : Fragment() {

    companion object {
        fun newInstance() = LeaderboardsFragment()
    }

    private lateinit var viewModel: LeaderboardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.leaderboards_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LeaderboardsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}