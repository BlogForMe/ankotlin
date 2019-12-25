package com.comm.util.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_skin_theme.view.*

/**
 * 绘制血压结果图
 */
class PressResultView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?,
                                                defStyleAttr: Int=0):View(context, attrs, defStyleAttr){


    private var rectHight: Float
    private var lineHeight: Float
    val mRtSrcPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val mLinePaint = Paint(Paint.ANTI_ALIAS_FLAG)


    init {
        rectHight = 100f
        lineHeight = 40f;

        mRtSrcPaint.apply {
            color = Color.parseColor("#A2CB79")
            strokeWidth = 1f
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
        }

        mLinePaint.apply {
            color = resources.getColor(android.R.color.holo_blue_light,context?.theme)
            strokeWidth = lineHeight
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val centerX = width/2f
        val centerY = height/2f

        var lineY = rectHight / 2

        canvas?.drawLine(0f,lineY,400f,lineY,mLinePaint)

        val rectF = RectF(0f,0f,1000f,rectHight)

        canvas?.drawRoundRect(rectF,centerX,centerY,mRtSrcPaint)



    }

}