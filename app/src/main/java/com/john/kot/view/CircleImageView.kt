package com.john.kot.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import timber.log.Timber
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.os.Build

/**
 * https://juejin.im/post/5b305f73f265da59b653b08d
 */
class CircleImageView(context: Context?, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    private var srcPath: Path? = null
    private var srcRectF: RectF? = null
    private var fermode: PorterDuffXfermode
    val isCircle: Boolean = true
    var cWidth: Int = 0
    var cHeight: Int = 0
    var cRadius: Float = 0f

    init {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1) {
            fermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        } else {
            fermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
            srcPath = Path()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        cWidth = w
        cHeight = h
        initSrcRectF()
    }

    private fun initSrcRectF() {
        if (isCircle) {
            cRadius = Math.min(cWidth, cHeight) / 2f
            srcRectF = RectF()
            srcRectF?.set(cWidth / 2f - cRadius, cHeight / 2f - cRadius, width / 2f + cRadius, height / 2f + cRadius)

            Timber.i("cWidth    $cWidth cHeight $cHeight  cradius $cRadius")
        }
    }

    override fun onDraw(canvas: Canvas?) {

        val sPaint = Paint().apply {
            color = Color.BLUE
            isAntiAlias = true
            style = Paint.Style.FILL
            xfermode = fermode
        }
        // 使用离屏缓存，新建一个srcRectF区域大小的图层
        Timber.i("width   ${width / 2f}")
        canvas?.saveLayer(srcRectF, null)
        super.onDraw(canvas)
        val path = Path()
        if (isCircle) {
            path.addCircle(cWidth / 2f, cHeight / 2f, cRadius, Path.Direction.CCW)
        }
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1) {
            canvas?.drawPath(path, sPaint)
        } else {
            srcPath?.addRect(srcRectF, Path.Direction.CCW)
            // 计算tempPath和path的差集
            srcPath?.op(path, Path.Op.DIFFERENCE)
            canvas?.drawPath(srcPath, sPaint)
        }
        sPaint.xfermode = null
    }
}