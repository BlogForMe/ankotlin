package com.john.kot.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.john.kot.R


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
class RoundImageShaderView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private lateinit var mRoundRect: RectF
    private lateinit var mBitmapShader: BitmapShader
    private val mMatrix = Matrix()
    private val mBitmapPaint = Paint();

    init {
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRoundRect(mRoundRect, 20f, 20f, mBitmapPaint)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setUpShader(R.drawable.meitu122822234759011)
        mRoundRect = RectF(0f, 0f, width.toFloat(), height.toFloat())
    }


    /**
     * 初始化BitmapShader
     */
    private fun setUpShader(id: Int) {
        val drawable: Drawable = getDrawable(context, id) ?: return
        val bmp = drawableToBitamp(drawable)
        // 将bmp作为着色器，就是在指定区域内绘制bmp
        mBitmapShader = BitmapShader(bmp!!, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        var scale = 1.0f
//        if (type === TYPE_CIRCLE) {
//            // 拿到bitmap宽或高的小值
//            val bSize = Math.min(bmp!!.width, bmp.height)
//            scale = mWidth * 1.0f / bSize
//        } else if (type === TYPE_ROUND) {
        // 如果图片的宽或者高与view的宽高不匹配，计算出需要缩放的比例；缩放后的图片的宽高，一定要大于我们view的宽高；所以我们这里取大值；
        scale = Math.max(width * 1.0f / bmp.width, height * 1.0f / bmp.height)
//        }
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
    private fun drawableToBitamp(drawable: Drawable): Bitmap? {
        if (drawable is BitmapDrawable) {
            val bd: BitmapDrawable = drawable
            return bd.bitmap
        }
        val w = drawable.intrinsicWidth
        val h = drawable.intrinsicHeight
        val bitmap: Bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, w, h)
        drawable.draw(canvas)
        return bitmap
    }
}