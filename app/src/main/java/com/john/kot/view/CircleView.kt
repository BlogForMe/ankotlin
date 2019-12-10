package com.john.kot.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import timber.log.Timber

/**
 * Android开发艺术探索 第四章
 */
class  CircleView : View {
    private val  mColor:Int = Color.RED;
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, null,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }

    private fun init() {
        mPaint.color = mColor
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paddingLeft =paddingLeft
        val paddingRight= paddingRight
        val padTop = paddingTop
        val padBottom = paddingBottom
        val width = width- paddingLeft - paddingRight
        val height = height - padTop - padBottom
        val radius  = Math.min(width,height)/2
        Timber.i("paddingLeft   ${getPaddingLeft()}   paddingRight  $paddingRight  paddingTop  $paddingTop  paddingBottom $paddingBottom ")

        canvas.drawCircle(paddingLeft+width/2f,paddingTop+height/2f, radius.toFloat(),mPaint)
        canvas.drawCircle(width/2f,height/2f, radius.toFloat(),mPaint)


    }


}