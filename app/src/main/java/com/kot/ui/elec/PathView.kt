package com.kot.ui.elec

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View
import timber.log.Timber

class PathView : View {
    private var cellPixel: Float = 0.toFloat()//每个小格宽度
    private val TAG = javaClass.simpleName
    private val cornerPathEffect = CornerPathEffect(20f)
    protected var stepx = 0.154f
    var mPaint: Paint? = null

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initPaint()
    }

    private fun initPaint() {
        mPaint = Paint()
        mPaint!!.pathEffect = cornerPathEffect
        mPaint?.color = Color.parseColor("#23BDC5")
        mPaint?.style = Paint.Style.STROKE
        mPaint?.strokeWidth = 5f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        cellPixel = measuredWidth / (25 * 5f)
        Log.i(TAG, "onMeasure  cellPixel  $cellPixel")
    }

    private var datas: List<Float>? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val path = Path()
        if (datas != null) {
            for (i in datas!!.indices) {
                path.lineTo(i * stepx, gethPx(datas!!.get(i)))
                Timber.i("stepx     $stepx  getPx    ${datas?.get(i)}")
            }
        }
        mPaint?.let { canvas?.drawPath(path, it) }
    }

    fun gethPx(data: Float): Float {
        return (data * cellPixel * 10f + 300)
    }


    fun setData(data: List<Float>) {
        datas = data
        invalidate()
    }


}