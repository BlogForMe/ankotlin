package com.john.kot.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import timber.log.Timber

class OnTouchEventView(mContext: Context?, attrs: AttributeSet?) :
    View(mContext, attrs) {

    init {
        isClickable = true
    }



    override fun onTouchEvent(event: MotionEvent): Boolean {
        Timber.i("onTouchEvent  ${event.action}")
        MotionEvent.ACTION_DOWN
        return super.onTouchEvent(event)
    }

}