package com.john.kot.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.john.kot.BuildConfig
import com.john.kot.util.DisplayUtils.sp2px
import com.john.kot.R


/**
 * 服务情况 圆
 */

class CirArcView : View {
    val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val mTxtPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val mLinePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mRadius: Float = 70f
    private var arcWidth: Float = 10f
    val mTxtTotalPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mContext: Context? = null
    var balanceTxt = "2000"
    var totalTxt = "5000"


    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        mContext = context
        val a = context?.theme?.obtainStyledAttributes(attrs, R.styleable.CirArcView, 0, 0)
        try {
            mRadius = a!!.getFloat(R.styleable.CirArcView_circleRadius, 70f)
            arcWidth = a!!.getFloat(R.styleable.CirArcView_arcWidth, 10f)
        } finally {
            a?.recycle()
        }
    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        val width: Int
//        val height: Int
//        var size = View.MeasureSpec.getSize(widthMeasureSpec)
//        var mode = View.MeasureSpec.getMode(widthMeasureSpec)
//
//        if (mode == View.MeasureSpec.EXACTLY) {
//            width = size
//        } else {
//            width = 2 * mRadius.toInt() + arcWidth.toInt()
//        }
//        size = View.MeasureSpec.getSize(heightMeasureSpec)
//        mode = View.MeasureSpec.getMode(heightMeasureSpec)
//        if (mode == View.MeasureSpec.EXACTLY) {
//            height = size
//        } else {
//            height = 2 * mRadius.toInt() + arcWidth.toInt()
//        }
//        setMeasuredDimension(width, height)
//    }

//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        super.onSizeChanged(w, h, oldw, oldh)
//        x = w / 2.0f
//        y = h / 2.0f
//    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        val centerX = width / 2.0f
        val centerY = height / 2.0f
        val rectF = RectF()
        rectF.left = arcWidth
        rectF.top = arcWidth
        rectF.right = centerX * 2 - arcWidth
        rectF.bottom = centerX * 2 - arcWidth

//        x = width / 2.0f
//        y = height / 2.0f


        mPaint.apply {
            color = Color.parseColor("#fff2f2f2")
            strokeWidth = arcWidth
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
        }

        mTxtPaint.apply {
            color = Color.parseColor("#4E6550")
            textSize = sp2px(mContext, 30f)
        }
        mLinePaint.apply {
            color = Color.parseColor("#DDDDDD")
            textSize = 10f
        }

        mTxtTotalPaint.apply {
            color = Color.parseColor("#999999")
            textSize = sp2px(mContext, 20f)
        }

        canvas?.drawCircle(centerX, centerY, mRadius, mPaint)

        mPaint.color = Color.parseColor("#A2CB79")
        canvas?.drawArc(rectF, -90f, mIncludedAngle, false, mPaint)


        val rect = Rect()
        mTxtPaint.getTextBounds(balanceTxt, 0, balanceTxt.length, rect)

        canvas?.drawText(balanceTxt, (centerX - rect.width() / 2), (centerY - 10), mTxtPaint)


        canvas?.drawLine(centerX - mRadius + arcWidth, centerY, centerX + mRadius - arcWidth, centerY, mLinePaint)
        val rectTotal = Rect()
        val totalTxt = "共$totalTxt"
        mTxtTotalPaint?.getTextBounds(totalTxt, 0, totalTxt.length, rectTotal)
        canvas?.drawText(
            totalTxt,
            (centerX - rectTotal.width() / 2),
            (centerY + rect.height() / 2 + 20),
            mTxtTotalPaint
        )
    }

     fun progress(bTxt: String, tTxt: String) {
        balanceTxt = bTxt
        totalTxt = tTxt
//        mIncludedAngle = balanceTxt.toFloat()
        startAnim(balanceTxt.toFloat() / tTxt.toInt() * 360)
        invalidate()
    }

    var mIncludedAngle = 0f
    fun startAnim(progress: Float) {
        val animator = ValueAnimator.ofFloat(0f, progress)
        animator.duration = 2000

        animator.setTarget(mIncludedAngle)
        animator.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener {
            override fun onAnimationUpdate(animation: ValueAnimator?) {
                mIncludedAngle = animation?.getAnimatedValue() as Float
                postInvalidate()
                if (BuildConfig.DEBUG) {
                    Log.d("CircleView", "onAnimationUpdate: percent = $mIncludedAngle")
                }
            }
        })
        animator.start()
    }

//    private fun getMySize(defaultSize: Int, measureSpec: Int): Int {
//        var mySize = defaultSize
//        val mode = View.MeasureSpec.getMode(measureSpec)
//        val size = View.MeasureSpec.getSize(measureSpec)
//        when (mode) {
//            View.MeasureSpec.UNSPECIFIED //如果没有指定大小，就设置为默认大小
//            -> mySize = defaultSize
//            View.MeasureSpec.AT_MOST//如果测量模式是最大取值为size
//            ->
//                //我们将大小取最大值,你也可以取其他值
//                mySize = size
//            View.MeasureSpec.EXACTLY -> mySize = size
//        }
//        return mySize
//    }
}