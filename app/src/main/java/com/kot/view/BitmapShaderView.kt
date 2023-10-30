package com.kot.view

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View
import com.kot.R
import kotlin.properties.Delegates


/**
 *
 * ClassName:      BitmapShaderView
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/8/14 4:42 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/8/14 4:42 PM
 * UpdateRemark:   Modify the description
 */
//  链接：https://juejin.cn/post/6844903480809766920
class BitmapShaderView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mWidth by Delegates.notNull<Int>()
    private var mHeight by Delegates.notNull<Int>()
    private lateinit var bmpShader: BitmapShader
    private lateinit var mPaint: Paint
    private lateinit var bmpRect: RectF

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w  //屏幕宽
        mHeight = h //屏幕高
        bmpRect = RectF(0f, 0f, mWidth.toFloat(), mHeight.toFloat())
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.meitu122822234759011)
        //Shader.TileMode里有三种模式：CLAMP（拉伸）、MIRROR（镜像）、REPETA（重复）
//        bmpShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        bmpShader = BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
//        bmpShader = BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR)
        bmpShader = BitmapShader(bitmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL)
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.shader = bmpShader //设置BitmapShader之后相当于绘制了底层的图片背景
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //这样就可以使用shader的纹理去覆盖绘制的图形的表面了,其中根据：CLAMP,REPEAT,MIRROR，
        //来确定纹理的绘制模式
        canvas?.drawRect(bmpRect, mPaint)
    }
}