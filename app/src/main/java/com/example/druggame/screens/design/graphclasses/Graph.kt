package com.example.druggame.screens.design.graphclasses

import android.content.Context
import android.util.Log
import android.widget.Toast

class Graph() {
    private val edges: ArrayList<Edge> = arrayListOf()
    val vertices: ArrayList<Vertex> = arrayListOf()

    fun addVertex (v: Vertex) {
        vertices.add(v)
    }

    private fun addEdge (e: Edge) {
        edges.add(e)
    }

    fun toastVertices (context: Context) {
        Toast.makeText(context, "Verticies: "+ vertices.size.toString(), Toast.LENGTH_LONG).show()
        vertices.forEach {
            Log.i("Verticies: ", it.coordinates.x.toString() + " " + it.coordinates.y.toString())
        }
    }

}