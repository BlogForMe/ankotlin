package com.kot.view

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View
import com.john.kot.R
import timber.log.Timber

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs) {


    private lateinit var mRoundRect: RectF
    private lateinit var mBitmapShader: BitmapShader
    private var resourceId: Int
    private val mMatrix = Matrix()
    private val mBitmapPaint = Paint();


    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, defStyleAttr)
        val boolean = a.getBoolean(R.styleable.CustomAttribute_customBoolean, false)
        val color = a.getColor(R.styleable.CustomAttribute_customColorValue, R.color.colorPrimary)
        val dimension = a.getDimension(R.styleable.CustomAttribute_customDimension, 20F)
        val float = a.getFloat(R.styleable.CustomView_attr_float, 20f)
        val fraction = a.getFraction(R.styleable.CustomView_attr_fraction, 1, 2, 0f)
        val integer = a.getInteger(R.styleable.CustomAttribute_customIntegerValue, 0)
        val string = a.getString(R.styleable.CustomView_attr_string)
        resourceId =
            a.getResourceId(R.styleable.CustomAttribute_customReference, R.drawable.meitu13333)
        var textPos = a.getInteger(R.styleable.CustomView_attr_enum, 0)
        a.recycle()
    }


    private fun setUpShader() {
        //        val drawable = AppCompatResources.getDrawable(context, resourceId)
        val bmp = BitmapFactory.decodeResource(resources, resourceId)
        // 将bmp作为着色器，就是在指定区域内绘制bmp
        mBitmapShader = BitmapShader(bmp!!, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        // 如果图片的宽或者高与view的宽高不匹配，计算出需要缩放的比例；缩放后的图片的宽高，一定要大于我们view的宽高；所以我们这里取大值；
        val scale = Math.max(width / bmp.width.toFloat(), height / bmp.height.toFloat())
        // shader的变换矩阵，我们这里主要用于放大或者缩小
        mMatrix.setScale(scale, scale)
        // 设置变换矩阵
        mBitmapShader.setLocalMatrix(mMatrix)
        // 设置shader
        mBitmapPaint.shader = mBitmapShader
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Timber.i("onDraw")
        canvas?.drawRoundRect(mRoundRect, 20f, 20f, mBitmapPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Timber.i("onMeasure")
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setUpShader()
        mRoundRect = RectF(0f, 0f, width.toFloat(), height.toFloat())
        Timber.i("onSizeChanged")
    }


    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Timber.i("onLayout")
    }
}