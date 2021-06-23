package com.android.util.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.android.util.DateUtil.minuteToHour
import com.android.util.DisplayUtils.dp2px
import com.android.util.DisplayUtils.sp2px
import com.android.util.R
import timber.log.Timber


/**
 * 睡眠表
 */
class ViewBodySleep : View {
    private var TUBE_TOP: Float = dp2px(context, 250f) //深度睡眠
    private val indexRect: Rect = Rect()

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        val a = context!!.obtainStyledAttributes(attrs, R.styleable.ViewBodySleep , defStyleAttr, 0)
//        linePaint.textSize   = a.getDimensionPixelSize(R.styleable.ViewBodySleep_vbltextsize,21).toFloat()
//        indexPaint.textSize   = a.getDimensionPixelSize(R.styleable.ViewBodySleep_vbltextsize,21).toFloat()

//        a.recycle()
    }

    val wakeHeight = dp2px(context, 37f) //减去清醒高度
    val paleHeight = dp2px(context, 54f) //减去浅度睡眠
    val darkHeight = dp2px(context, 72f) //深度睡眠
    var mWidth = 0f

    val TUBE_DIAMETER = dp2px(context, 40f) //圆直径
    private val linePaint: Paint = Paint().apply { //横线和 刻度颜色
        color = Color.parseColor("#DDDDDD");
        strokeWidth = dp2px(context, 2f)
        textSize = sp2px(context, 15f)
    }

    private val indexPaint: Paint = Paint().apply {
        color = Color.parseColor("#DDDDDD");
        textSize = sp2px(context, 15f)
    }
    private val rectPaint: Paint = Paint().apply { //睡眠矩形
        color = Color.parseColor("#3989AC")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = (w - paddingLeft - paddingRight).toFloat() //控件宽度
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var unitWidth = mWidth / 72
        var wakeCount = 0 //出现的次数
        var paleCount = 0
        var darkCount = 0
        var notCheckCount = 0
        for ((index, value) in sleepData?.withIndex()) {
            println("$index: $value")
            //0代表清醒，1代表浅睡，2代表深睡，3代表未检测
            val startX = paddingLeft.toFloat() + unitWidth * index
            when (value.toString()) {
                "1" -> {
                    rectPaint.color = Color.parseColor("#23BDC5")
                    canvas?.drawRect(
                            startX,
                            darkHeight - paleHeight,
                            startX + unitWidth,
                            darkHeight,
                            rectPaint
                    )
                    paleCount++
                }
                "2" -> {
                    rectPaint.color = Color.parseColor("#3989AC")
                    canvas?.drawRect(startX, 0f, startX + unitWidth, darkHeight, rectPaint)
                    darkCount++
                }
                "3"  -> {
                    rectPaint.color = Color.parseColor("#ffdddddd")
                    canvas?.drawRect( startX,darkHeight - wakeHeight,startX + unitWidth, darkHeight, rectPaint)
                    notCheckCount++
                }
                "0"->{
                    rectPaint.color = Color.parseColor("#D1ECEE")
                    canvas?.drawRect( startX,darkHeight - wakeHeight,startX + unitWidth, darkHeight, rectPaint)
                    wakeCount++
                }
            }
        }
        if (sleepData.isEmpty()){
            rectPaint.color =  Color.parseColor("#DDDDDD")
            canvas?.drawRect(paddingLeft.toFloat(),darkHeight - paleHeight, paddingLeft+mWidth,darkHeight,rectPaint)
        }

        canvas?.drawLine(
                paddingLeft.toFloat(),
                darkHeight,
                paddingLeft.toFloat() + mWidth,
                darkHeight,
                linePaint
        )
        var indexHeight = 20f
        for (i in 0..12) {
            linePaint.getTextBounds(i.toString(), 0, i.toString().length, indexRect)
            indexHeight = darkHeight + indexRect.height() + dp2px(context, 10f) //底部刻度高度
            if (i < 2) {
                canvas?.drawText(
                        (22 + i).toString(),
                        paddingLeft.toFloat() + unitWidth * 6 * i - indexRect.width() / 2,
                        indexHeight,
                        linePaint
                )
            } else {
                canvas?.drawText(
                        (i - 2).toString(),
                        paddingLeft.toFloat() + unitWidth * 6 * i - indexRect.width() / 2,
                        indexHeight,
                        linePaint
                )
            }
        }

        indexPaint.getTextBounds("睡眠时间表", 0, "睡眠时间表".length, indexRect)
        val SLEEP_HEIGHT = indexHeight + indexRect.height() + 20 //睡眠文字高度
        indexPaint.color = Color.parseColor("#999999")
        canvas?.drawText("睡眠时间表", mWidth / 2 - indexRect.width() / 2, SLEEP_HEIGHT, indexPaint)

        /**
         * 绘制管道
         */
        TUBE_TOP = SLEEP_HEIGHT + dp2px(context, 20f) //管道上边坐标

        indexPaint.color = Color.WHITE

        val UNINT_TUBE = (mWidth - TUBE_DIAMETER) / 72 //管道的单位长度 不能放成员位置,mWidth =0

        /**
         * 深度睡眠区块
         */
        val darkPath = Path()
        val rectF = RectF(paddingLeft.toFloat(), TUBE_TOP, paddingLeft + TUBE_DIAMETER, TUBE_TOP + TUBE_DIAMETER)
        darkPath.addArc(rectF, 90f, 180f) //绘制左侧圆弧
        darkPath.lineTo((paddingLeft + TUBE_DIAMETER / 2f + UNINT_TUBE * darkCount), TUBE_TOP)
        darkPath.lineTo((paddingLeft + TUBE_DIAMETER / 2f + UNINT_TUBE * darkCount), TUBE_TOP + TUBE_DIAMETER) //绘制右侧矩形
        if (sleepData.isEmpty()){
            rectPaint.color =  Color.parseColor("#DDDDDD")
        }else{
            rectPaint.color = Color.parseColor("#3989AC")
        }

        canvas?.drawPath(darkPath, rectPaint)


        /**
         *浅度睡眠区块
         */
        if (sleepData.isNotEmpty()){
            rectPaint.color = Color.parseColor("#23BDC5")
        }
        canvas?.drawRect(paddingLeft + TUBE_DIAMETER / 2f + UNINT_TUBE * darkCount, TUBE_TOP, paddingLeft + TUBE_DIAMETER / 2f + UNINT_TUBE * (darkCount + paleCount), TUBE_TOP + TUBE_DIAMETER, rectPaint)


        /**
         * 清醒
         */

        if (sleepData.isNotEmpty()){
            rectPaint.color = Color.parseColor("#D1ECEE")
        }
        canvas?.drawRect(paddingLeft + TUBE_DIAMETER / 2f + UNINT_TUBE * (darkCount + paleCount), TUBE_TOP, mWidth, TUBE_TOP + TUBE_DIAMETER, rectPaint)
        val wakePath = Path()
        val rectWake = RectF(mWidth - TUBE_DIAMETER / 2, TUBE_TOP, mWidth + TUBE_DIAMETER / 2, TUBE_TOP + TUBE_DIAMETER)
        wakePath.addArc(rectWake, 270f, 180f)
        canvas?.drawPath(wakePath, rectPaint)

        if (darkCount != 0) {
            canvas?.drawText(minuteToHour(darkCount * 10), paddingLeft + 10f, TUBE_TOP + TUBE_DIAMETER / 2 + indexRect.height() / 2, indexPaint)  //上边+半径+字高度一半
        }
        if (paleCount != 0) {
            canvas?.drawText(minuteToHour(paleCount * 10), paddingLeft + TUBE_DIAMETER / 2f + UNINT_TUBE * darkCount + 10f, TUBE_TOP + TUBE_DIAMETER / 2 + indexRect.height() / 2, indexPaint)  //上边+半径+字高度一半
        }
        if (wakeCount != 0) {
            canvas?.drawText(minuteToHour(wakeCount * 10), mWidth - 50f, TUBE_TOP + TUBE_DIAMETER / 2 + indexRect.height() / 2, indexPaint)  //上边+半径+字高度一半
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec);
        val widthSize = MeasureSpec.getSize(widthMeasureSpec); //widthSize父控件留个子空间的最大宽度

        val heightMode = MeasureSpec.getMode(heightMeasureSpec);
        val heightSize = MeasureSpec.getSize(heightMeasureSpec);

//        var width = 10
        var height = 10
//        if (widthMode == MeasureSpec.EXACTLY) {   //如果match_parent或者具体的值，直接赋值
//            width = widthSize
//        } else if (widthMode == MeasureSpec.AT_MOST) { //如果是wrap_content，我们要得到控件需要多大的尺寸
////            width = paddingLeft + mBound.width() + paddingRight
//        }
//高度跟宽度处理方式一样
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = (paddingTop + TUBE_TOP + paddingBottom).toInt()
        }
        Timber.i("height $height")
        setMeasuredDimension(width, height)
    }

    private var sleepData: String = ""
    fun setSleepData(data: String) {
        sleepData = data
        invalidate()
    }


}