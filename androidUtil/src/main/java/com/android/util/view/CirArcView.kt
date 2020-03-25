package com.android.util.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.android.util.DisplayUtils.sp2px
import com.android.util.R


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
    var balanceTxt = "0"
    var totalTxt = "0"


    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        mContext = context
        val a = context?.theme?.obtainStyledAttributes(attrs, R.styleable.CirArcView, 0, 0)
        try {
            mRadius = a!!.getFloat(R.styleable.CirArcView_circleCRadius, 70f)
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
            textSize = sp2px(mContext, 20f)
        }
        mLinePaint.apply {
            color = Color.parseColor("#DDDDDD")
            textSize = 10f
        }

        mTxtTotalPaint.apply {
            color = Color.parseColor("#999999")
            textSize = sp2px(mContext, 25f)
        }

        canvas?.drawCircle(centerX, centerY, mRadius, mPaint)

        mPaint.color = Color.parseColor("#A2CB79")
        canvas?.drawArc(rectF, -90f, mIncludedAngle, false, mPaint)



        var totalShowTxt = ""
        val rectTotal = Rect()
        if (totalTxt.toInt() > 99999) {
            totalShowTxt = "不限"
            mTxtTotalPaint?.getTextBounds(totalShowTxt, 0, totalShowTxt.length, rectTotal)
            canvas?.drawText(totalShowTxt, (centerX - rectTotal.width() / 2), centerY + rectTotal.height()/2, mTxtTotalPaint)
            return
        } else {
            totalShowTxt = balanceTxt
        }
        val rect = Rect()
        mTxtTotalPaint?.getTextBounds(totalShowTxt, 0, totalShowTxt.length, rectTotal)
        canvas?.drawText(totalShowTxt, (centerX - rectTotal.width() / 2), (centerY + rectTotal.height() / 2 + 20), mTxtTotalPaint)

        var showUse = ""
        if (balanceTxt.toInt() > 99999) {
            showUse = "不限"
        } else {
            showUse = "剩余"
        }
        mTxtPaint.getTextBounds(showUse, 0, showUse.length, rect)
        canvas?.drawText(showUse, (centerX - rect.width() / 2), (centerY - 10), mTxtPaint)
//        canvas?.drawLine(centerX - mRadius + arcWidth, centerY, centerX + mRadius - arcWidth, centerY, mLinePaint)
    }

    open fun progress(bTxt: String, tTxt: String) {
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
//                if (BuildConfig.DEBUG) {
//                    Log.d("CircleView", "onAnimationUpdate: percent = $mIncludedAngle")
//                }
            }
        })
        animator.start()
    }

}