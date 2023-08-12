package com.kot.view.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.android.util.DisplayUtils

class XYRelativeLayout :RelativeLayout{
    var mLinePaint = Paint(Paint.ANTI_ALIAS_FLAG)


    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, null,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        setWillNotDraw(false)
    }

    private var mCenterX: Float
    private var mCenterY: Float

    init {
        mCenterX = DisplayUtils.getScreenW(context)
        mCenterY = DisplayUtils.getScreenH(context)

        mLinePaint.apply {
            color = Color.parseColor("#333333")
            strokeWidth = 4f
            style = Paint.Style.STROKE
        }

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f,mCenterY/2f,mCenterX,mCenterY/2f,mLinePaint)
        canvas?.drawLine(mCenterX/2,0f,mCenterX/2,mCenterY,mLinePaint)
    }

}