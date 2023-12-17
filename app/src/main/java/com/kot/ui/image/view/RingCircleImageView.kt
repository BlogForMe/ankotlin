package com.kot.ui.image.view

/**
 *
 * ClassName:      RingCircleImageView
 * Description:    Description
 * Author:         zh
 * CreateDate:     12/17/23 21:18
 * UpdateUser:     zh
 * UpdateDate:     12/17/23 21:18
 * UpdateRemark:   Modify the description
 */

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class RingCircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint = Paint()
    private var ringColor: Int =
        context.resources.getColor(android.R.color.holo_blue_light) // Default color
    private var ringWidth: Int = 10 // Default width

    init {
        paint.isAntiAlias = true
    }

    fun setRingColor(color: Int) {
        ringColor = color
        invalidate()
    }

    fun setRingWidth(width: Int) {
        ringWidth = width
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val viewWidth = width
        val viewHeight = height
        val centerX = viewWidth / 2
        val centerY = viewHeight / 2
        val radius = (Math.min(centerX, centerY) - ringWidth / 2).toFloat()

        paint.color = ringColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = ringWidth.toFloat()

        canvas.drawCircle(centerX.toFloat(), centerY.toFloat(), radius, paint)
    }
}
