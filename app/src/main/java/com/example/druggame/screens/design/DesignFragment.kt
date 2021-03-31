package com.example.druggame.screens.design

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.druggame.R
import com.example.druggame.databinding.DesignFragmentBinding
import com.example.druggame.screens.design.graphclasses.Graph

class DesignFragment : Fragment() {

    private lateinit var binding : DesignFragmentBinding
    private lateinit var viewModel: DesignViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(this).get(DesignViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.design_fragment, container, false)
        binding.lifecycleOwner = this
//
//        viewModel.graph.observe(viewLifecycleOwner, Observer {
//            binding.designCanvasView.graph = it
//        })
//
//        viewModel.currentState.observe(viewLifecycleOwner, Observer {
//            binding.designCanvasView.state = it
//        })

        binding.butt.setOnClickListener {
            binding.designCanvasView.state = viewModel.currentState.value!!
        }

        return binding.root
    }

}