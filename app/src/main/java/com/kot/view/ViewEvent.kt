package com.kot.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class ViewEvent : View {

    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onTouchEvent(event: MotionEvent?): Boolean {



        return super.onTouchEvent(event)
    }


}