package com.john.ankotlin.elec

import android.content.Context
import android.graphics.Color
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class PathView  : View{
    private var mPaint: Paint  = Paint()

    private var cellPixel: Float = 0.toFloat()//每个小格宽度
    private val TAG = javaClass.simpleName
    private val cornerPathEffect = CornerPathEffect(20f)

    protected var stepx = 0.154f


    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initPaint()
    }

    private fun initPaint() {
        mPaint.setPathEffect(cornerPathEffect)
        mPaint.setColor(Color.parseColor("#23BDC5"));
        mPaint.setStyle(Paint.Style.STROKE)
        mPaint.setStrokeWidth(5f)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }



}