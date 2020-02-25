package com.john.kot.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * save restore leaning
 *
 * https://programmer.group/android-canvas-save-save-layer-and-restore.html
 * https://www.cnblogs.com/liangstudyhome/p/4143498.html
 */
class SaveRestoreView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {

    private val bgPaint: Paint  //背景
    private val linePaint: Paint

    init {

        bgPaint = Paint().apply {
            color = Color.GRAY;
        }

        linePaint = Paint().apply {
            color = Color.RED;
            strokeWidth = 4f
        }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val px = 500f
        val py = 500f

        canvas?.drawLine(0f,200f,700f,200f,linePaint)
        canvas?.save()  //将画布状态保存

        canvas?.rotate(90f, px / 2, py / 2);
        canvas?.restore();//恢复画布状态
        canvas?.drawLine(0f,400f,700f,400f,bgPaint)


    }

}