package com.kot.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import timber.log.Timber

class CustomViewOnMeasure : View {
    val DEFAULT_VIEW_WIDTH = 100
    val DEFAULT_VIEW_HEIGHT = 100

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        init(context, attrs)
    }

//    private fun init(context: Context?, attrs: AttributeSet?) {
//    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Timber.i("$widthMeasureSpec   $heightMeasureSpec")
        val width = measureDimension(DEFAULT_VIEW_WIDTH, widthMeasureSpec)
        val height = measureDimension(DEFAULT_VIEW_WIDTH, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    private fun measureDimension(defaultSize: Int, measureSpec: Int): Int {
        var result = defaultSize
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        when (specMode) {
            MeasureSpec.EXACTLY -> result = specSize
            MeasureSpec.AT_MOST -> result = Math.min(defaultSize, specSize)
            else -> result = defaultSize
        }
        return result
    }
}