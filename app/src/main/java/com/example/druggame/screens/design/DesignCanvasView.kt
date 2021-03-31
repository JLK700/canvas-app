package com.example.druggame.screens.design

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.adapters.ToolbarBindingAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.druggame.R
import com.example.druggame.screens.design.graphclasses.Graph
import com.example.druggame.screens.design.graphclasses.Vertex
import kotlin.math.pow
import kotlin.math.sqrt

class DesignCanvasView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context) {

    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    var graph : Graph = Graph()

    private val paintColor = ResourcesCompat.getColor(resources, R.color.teal_200, null)
    private val paint = Paint().apply {
        color = paintColor
        isAntiAlias = true
        isDither = true
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = 10f
    }

    var temp = true
    var state = "sth"
    private var myX = 0f
    private var myY = 0f


    private fun isItPoint(x: Float, y: Float): Boolean {
        graph.vertices.forEach {
            val dist = sqrt((it.coordinates.x - x).pow(2) + (it.coordinates.y - y).pow(2))
            if (dist < 30f) {
                return true
            }
        }
        return false
    }

    private fun touchStart() {
        if (temp) {
            temp = false
            graph.addVertex(Vertex(PointF(myX, myY), "C"))
            Toast.makeText(context, state, Toast.LENGTH_SHORT).show()
            extraCanvas.drawCircle(myX, myY, 30f, paint)
            invalidate()
        } else {
            temp = true
            val dupa: Boolean = isItPoint(myX, myY)
            Toast.makeText(context, dupa.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(resources.getColor(R.color.purple_200))

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(extraBitmap, 0f, 0f, null)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        myX = event.x
        myY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
        }


        return true
    }

}