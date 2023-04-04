package com.john.kot.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.john.kot.R
import android.graphics.*


class MyTextView : View {
    private lateinit var mPaint: Paint
    private var BaseY: Int = 0
    private var BaseX: Int = 0

    private lateinit var mBound: Rect
    private var mTextSize: Float = 0f
    private var mTextColor: Int = Color.BLUE
    var mText: String = "文字"
        set(value) {
            field = value
            invalidate()
        }

    val DEFAULT_VIEW_WIDTH = 100
    val DEFAULT_VIEW_HEIGHT = 100


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.MyTextView, 0, defStyleAttr)
        mText = a.getString(R.styleable.MyTextView_mText) ?: "";
        mTextColor = a.getColor(R.styleable.MyTextView_mTextColor, Color.BLACK);
        mTextSize = a.getDimension(R.styleable.MyTextView_mTextSize, 100f);
        a.recycle()

        mPaint = Paint().apply {
            textSize = mTextSize
            color = mTextColor
            typeface = Typeface.DEFAULT_BOLD
        }
        mBound = Rect()
        mText.length.let { mPaint.getTextBounds(mText, 0, it, mBound) }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        BaseX = getWidth() / 2 - mBound.width() / 2;
        BaseY = getHeight() / 2 + mBound.height() / 2;
        canvas?.drawText(mText, BaseX.toFloat(), BaseY.toFloat(), mPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec);
        val widthSize = MeasureSpec.getSize(widthMeasureSpec);

        val heightMode = MeasureSpec.getMode(heightMeasureSpec);
        val heightSize = MeasureSpec.getSize(heightMeasureSpec);

        var width = 10
        var height = 10
        if (widthMode == MeasureSpec.EXACTLY) {   //如果match_parent或者具体的值，直接赋值
            width = widthSize
        } else if (widthMode == MeasureSpec.AT_MOST) { //如果是wrap_content，我们要得到控件需要多大的尺寸
            width = paddingLeft + mBound.width() + paddingRight
        }
        //高度跟宽度处理方式一样
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize
        } else if (widthMode == MeasureSpec.AT_MOST) {
            height = paddingTop + mBound.height() + paddingBottom
        }
        setMeasuredDimension(width, height)
    }


//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        Timber.i("$widthMeasureSpec   $heightMeasureSpec")
//        val width = measureDimension(DEFAULT_VIEW_WIDTH, widthMeasureSpec)
//        val height = measureDimension(DEFAULT_VIEW_WIDTH, heightMeasureSpec)
//        setMeasuredDimension(width, height)
//    }

    private fun measureDimension(defaultSize: Int, measureSpec: Int): Int {
        var result = defaultSize
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        when (specMode) {
            MeasureSpec.EXACTLY -> result = specSize
            MeasureSpec.AT_MOST -> result = Math.min(defaultSize, specSize)
            else -> result = defaultSize
        }
        return result
    }
}