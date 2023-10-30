package com.android.util.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import timber.log.Timber

// https://juejin.im/entry/589542d61b69e600598673ed
class RelativeLayoutRate : RelativeLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setWillNotDraw(false)
    }


    private val darkPaint: Paint = Paint().apply { //睡眠矩形
        color = Color.parseColor("#3989AC")
    }
    private val lightPaint: Paint = Paint().apply { //睡眠矩形
        color = Color.parseColor("#D1ECEE")
    }


    var mActivityTime = 7
    var mCalmTime = 3
    fun setTime(activityTime: Int, calmTime: Int) {
        mActivityTime = activityTime
        mCalmTime = calmTime
        invalidate()
    }


    var mWidth = 0f
    var mHeight = 0f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h.toFloat();
    }

    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
        Timber.i("mWidth $mWidth mHeight $mHeight")

        if (mActivityTime == 0) {
            return
        }
        canvas?.drawRect(
            0f,
            0f,
            mWidth * mActivityTime / (mActivityTime + mCalmTime),
            mHeight,
            darkPaint
        )
        canvas?.drawRect(
            mWidth * mActivityTime / (mActivityTime + mCalmTime),
            0f,
            mWidth,
            mHeight,
            lightPaint
        )

    }
}