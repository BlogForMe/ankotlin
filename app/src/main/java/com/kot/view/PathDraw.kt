package com.kot.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.android.util.DisplayUtils

class PathDraw @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val txtPaint: Paint = Paint().apply {
        color = Color.parseColor("#DDDDDD");
        strokeWidth = DisplayUtils.dp2px(context, 2f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas?.translate(width / 2.toFloat(), height / 2.toFloat())
//        canvas?.scale(1f,-1f)
        val path = Path()
        path.addArc(0f, 0f, 200f, 200f, 90f, 180f)
        path.lineTo(200f, 300f)
        canvas?.drawPath(path, txtPaint)
    }


}