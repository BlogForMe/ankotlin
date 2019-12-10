package com.comm.util.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * 绘制血压结果图
 */
class PressResultView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?,
                                                defStyleAttr: Int=0):View(context, attrs, defStyleAttr){


    val mRtSrcPaint = Paint(Paint.ANTI_ALIAS_FLAG)


    init {
        mRtSrcPaint.apply {
            color = Color.parseColor("#A2CB79")
            strokeWidth = 1f
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
            textSize = 28f
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val rectF = RectF(0f,100f,1000f,50f)
        canvas?.drawRoundRect(rectF,100f,500f,mRtSrcPaint)
    }

}