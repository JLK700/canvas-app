package com.example.druggame.screens.design

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.druggame.screens.design.graphclasses.Graph

class DesignViewModel : ViewModel() {
    val graph = MutableLiveData<Graph>(Graph())
    val currentState = MutableLiveData<String>("Green")
}