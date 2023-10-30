package com.kot.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class TempCircleView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val srcPaint: Paint
    private val innnerPaint: Paint
    private val innerRadius = 42f

    init {
        srcPaint = Paint().apply {
            color = Color.parseColor("#37BC95");
        }

        innnerPaint = Paint().apply {
            color = Color.parseColor("#A2CB79");
        }


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        val srcRadius: Float = (innerRadius + 8)

//        Timber.i("centerX   $centerX   centerY  $centerY")
        canvas?.drawCircle(centerX, centerY, srcRadius, srcPaint);
        canvas?.drawCircle(centerX, centerY, innerRadius, innnerPaint);

        var circleX = (centerX - innerRadius + 20)
        for (i in 0..2) {
            val rectF = RectF(circleX+(10*i), centerY-20f, circleX+10f+(10*i), centerY+20);
            circleX = (circleX + 10);
            canvas?.drawRoundRect(rectF, 10f, 10f, srcPaint)
        }

    }
}

