package com.john.kot.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.john.kot.R
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
class RoundXfermodeBitmapShaderView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private lateinit var bitmap: Bitmap
    private var mMatrix = Matrix()
    val paint = Paint().apply {
        isAntiAlias = true
    }
    val mRadius = resources.getDimension(R.dimen.round_bitmap_radius)

    private var outHeight by Delegates.notNull<Int>()
    private var outWidth by Delegates.notNull<Int>()
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        outWidth = w
        outHeight = h
        setUpShader()
    }

    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)  //否则Canvas又会在ImageView中重新绘制，将我们之前的操作都覆盖了

        val newBt = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)


        // 初始化目标bitmap
        val targetBitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888)

        val canvas = Canvas(targetBitmap)
        canvas.drawARGB(0, 0, 0, 0)
        val rectF = RectF(0f, 0f, outWidth.toFloat(), outHeight.toFloat())
//        // 在画布上绘制圆角图
        canvas?.drawBitmap(targetBitmap, null, rectF, paint)
//        // 设置叠加模式
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        // 在画布上绘制原图片
        val ret = Rect(0, 0, outWidth, outHeight)
        canvas?.drawBitmap(newBt, ret, ret, paint)
    }

    /**
     * 初始化BitmapShader
     */
    private fun setUpShader() {
        val drawable: Drawable = drawable ?: return
        bitmap = drawableToBitmap(drawable)
        // 等比例缩放拉伸
        val widthScale = outWidth * 1.0f / bitmap.width
        val heightScale = outHeight * 1.0f / bitmap.height
        mMatrix = Matrix()
        matrix.setScale(widthScale, heightScale)
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