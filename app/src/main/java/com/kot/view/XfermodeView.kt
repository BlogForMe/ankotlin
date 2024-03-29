package com.kot.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.kot.R

/**
 *
 * ClassName:      XfermodeView
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/8/29 4:31 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/8/29 4:31 PM
 * UpdateRemark:   Modify the description
 */

private const val TYPE_CIRCLE = 0
private const val TYPE_ROUND = 1

class XfermodeView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var src: Bitmap? = null
    private var out: Bitmap? = null

    private var mWidth = 0
    private var mHeight = 0
    private var type = TYPE_ROUND  //设置类型，是圆角图片还是圆角矩形

    init {
        // 禁止硬件加速，硬件加速会有一些问题，这里禁用掉
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        //自己计算控件的宽高
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        mWidth = if (widthMode == MeasureSpec.EXACTLY) {
            widthSize
        } else {
            val imgWidth = (src!!.width + paddingLeft
                    + paddingRight)
            if (widthMode == MeasureSpec.AT_MOST) {
                Math.min(widthSize, imgWidth)
            } else {
                imgWidth
            }
        }
        mHeight = if (heightMode == MeasureSpec.EXACTLY) {
            heightSize
        } else {
            val imgHeight = (src!!.height + paddingTop
                    + paddingBottom)
            if (heightMode == MeasureSpec.AT_MOST) {
                Math.min(heightSize, imgHeight)
            } else {
                imgHeight
            }
        }
        when (type) {
            TYPE_CIRCLE -> {
                val min = Math.min(mWidth, mHeight)
                setMeasuredDimension(min, min)
            }
            TYPE_ROUND -> setMeasuredDimension(mWidth, mHeight)
        }
    }

    override fun onDraw(canvas: Canvas) {
        xmodeImage()
        //把画好画的画布放到自定义的画板上面
        canvas.drawBitmap(out!!, 0f, 0f, null)
    }

    private fun xmodeImage() {
        //根据原始的图片创建一个画布
        out = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888)

        //创建一个画板，在画布的基础上
        val canvas = Canvas(out!!)
        //创建一个画笔
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        when (type) {
            TYPE_ROUND ->            //开始在有画板的画布上用画笔作画了，这里画了一个圆角矩形
                canvas.drawRoundRect(
                    RectF(0f, 0f, mWidth.toFloat(), mHeight.toFloat()),
                    60f,
                    60f,
                    paint
                )
            TYPE_CIRCLE -> {
                //画圆，取宽高的最小值作为圆的直径
                val min = Math.min(mWidth, mHeight)
                //开始画圆
                canvas.drawCircle(
                    (min / 2).toFloat(),
                    (min / 2).toFloat(),
                    (min / 2).toFloat(),
                    paint
                )
            }
        }
        src = BitmapFactory.decodeResource(resources, R.drawable.meitu110468869)
        //设置Xfermode画笔模式为SRC_IN
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        //然后有画了一个图片，最终实现两个图像的叠加

        val zoomImg = zoomImg(src!!, mWidth, mHeight)
        canvas.drawBitmap(zoomImg!!, 0f, 0f, paint)
    }

    fun zoomImg(bm: Bitmap, newWidth: Int, newHeight: Int): Bitmap? {
        // 获得图片的宽高
        val width = bm.width
        val height = bm.height
        // 计算缩放比例
        val scaleWidth = newWidth.toFloat() / width
        val scaleHeight = newHeight.toFloat() / height
        // 取得想要缩放的matrix参数
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        // 得到新的图片
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true)
    }
}