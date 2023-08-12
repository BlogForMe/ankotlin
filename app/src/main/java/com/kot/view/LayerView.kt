package com.kot.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 图层
 * https://www.cnblogs.com/liangstudyhome/p/4143498.html
 */
class LayerView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mPaint: Paint

    init {
        mPaint = Paint().apply {
            color = Color.WHITE;
            strokeWidth = 4f
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.color = Color.RED
        canvas?.drawCircle(75f, 75f, 75f, mPaint);
        canvas?.saveLayerAlpha(0f, 0f, 200f, 200f, 0x88);
        mPaint.color = Color.BLUE
        canvas?.drawCircle(125f, 125f, 75f, mPaint);
        canvas?.restore();
    }

}