package com.john.ankotlin.ui.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import timber.log.Timber

class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    init {
        Timber.i("init")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Timber.i("onDraw")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Timber.i("onMeasure")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Timber.i("onSizeChanged")
    }


    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Timber.i("onLayout")
    }
}