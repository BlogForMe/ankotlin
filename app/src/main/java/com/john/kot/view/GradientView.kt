package com.john.kot.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class GradientView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        /**
         * LinearGradient
         * Create a shader that draws a linear gradient along a line.
         *
         * @param x0           The x-coordinate for the start of the gradient line
         * @param y0           The y-coordinate for the start of the gradient line
         * @param x1           The x-coordinate for the end of the gradient line
         * @param y1           The y-coordinate for the end of the gradient line
         * @param colors       The colors to be distributed along the gradient line
         * @param positions    May be null. The relative positions [0..1] of
         *                     each corresponding color in the colors array. If this is null,
         *                     the the colors are distributed evenly along the gradient line.
         *                     所占比例，如果传null，则均匀渲染
         * @param tile         The Shader tiling mode
         */
//        val colors = intArrayOf(
//            Color.RED, Color.GREEN, Color.BLUE
//        )
//        val positions = floatArrayOf(0.5f, 1f, 0.5f)
//        val linearGradient = LinearGradient(0f, 300f, 300f, 300f, colors, positions, Shader.TileMode.CLAMP)
//        val mPaint = Paint()
//        mPaint.setShader(linearGradient)
//        canvas?.drawRect(0f, 0f, 300f, 300f, mPaint)

        val colors = intArrayOf(
            Color.parseColor("#EEEEEE"),
            Color.parseColor("#F2F2F2"),
            Color.parseColor("#E6E6E6")
        )
        val positions = floatArrayOf(0.2f,0.5f,1f)
        val linearGradient = LinearGradient(0f, 300f, 300f, 300f, colors, positions, Shader.TileMode.MIRROR)
        val mPaint = Paint()
        mPaint.setShader(linearGradient)
        canvas?.drawRect(0f, 0f, 1000f, 300f, mPaint)
    }

}