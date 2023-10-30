package com.kot.view

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

    private val gryayPaint: Paint = Paint().apply {
        color = Color.GRAY;
    }

    private val redPaint: Paint = Paint().apply {
        color = Color.RED;
        strokeWidth = 4f
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val px = 500f
        val py = 500f


        canvas?.drawLine(0f, 200f, 700f, 200f, gryayPaint)
        canvas?.save()  //将画布状态保存

        canvas?.rotate(90f, px / 2, py / 2);
        canvas?.restore();//恢复画布状态  这个操作能撤销到 上次保存的画布状态
        canvas?.drawLine(0f,400f,700f,400f,redPaint)


    }

}