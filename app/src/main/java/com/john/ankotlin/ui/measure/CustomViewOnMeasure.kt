package com.john.ankotlin.ui.measure

import android.content.Context
import android.util.AttributeSet
import android.view.View

class CustomViewOnMeasure : View {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        init(context, attrs)
    }

//    private fun init(context: Context?, attrs: AttributeSet?) {
//    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}