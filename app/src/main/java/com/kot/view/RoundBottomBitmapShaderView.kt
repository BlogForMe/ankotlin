package com.kot.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.kot.R
import kotlin.properties.Delegates


/**
 *
 * ClassName:      RoundImageShaderView
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/8/14 6:05 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/8/14 6:05 PM
 * UpdateRemark:   Modify the description
 */
// https://blog.csdn.net/lmj623565791/article/details/41967509
class RoundBottomBitmapShaderView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private lateinit var mBitmapShader: BitmapShader
    private val mMatrix = Matrix()
    private val mBitmapPaint = Paint();

    val radius = resources.getDimension(R.dimen.round_bitmap_radius)

    private var outHeight by Delegates.notNull<Int>()
    private var outWidth by Delegates.notNull<Int>()
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setUpShader()
        outWidth = w
        outHeight = h
    }

    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)  //否则Canvas又会在ImageView中重新绘制，将我们之前的操作都覆盖了

        //绘制圆角
        canvas?.drawRoundRect(
            RectF(
                0f,
                (outHeight - 2 * radius), outWidth.toFloat(), outHeight.toFloat()
            ), radius, radius, mBitmapPaint
        )
//         利用画笔绘制顶部上面直角部分
        canvas?.drawRect(
            RectF(
                0f, 0f, outWidth.toFloat(),
                (outHeight - radius)
            ), mBitmapPaint
        )


    }

    /**
     * 初始化BitmapShader
     */
    private fun setUpShader() {
        val drawable: Drawable = drawable ?: return
        val bmp = drawableToBitmap(drawable)
        // 将bmp作为着色器，就是在指定区域内绘制bmp
        mBitmapShader = BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        // 如果图片的宽或者高与view的宽高不匹配，计算出需要缩放的比例；缩放后的图片的宽高，一定要大于我们view的宽高；所以我们这里取大值；
        val scale = Math.max(width / bmp.width.toFloat(), height / bmp.height.toFloat())
        // shader的变换矩阵，我们这里主要用于放大或者缩小
        mMatrix.setScale(scale, scale)
        // 设置变换矩阵
        mBitmapShader.setLocalMatrix(mMatrix)
        // 设置shader
        mBitmapPaint.shader = mBitmapShader
    }

    /**
     * drawable转bitmap
     *
     * @param drawable
     * @return
     */
    private fun drawableToBitmap(drawable: Drawable): Bitmap {
        if (drawable is BitmapDrawable) {
            val bd: BitmapDrawable = drawable
            return bd.bitmap
        }
        val w = drawable.intrinsicWidth
        val h = drawable.intrinsicHeight
        return Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
    }
}