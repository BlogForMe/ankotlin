package com.john.ankotlin.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.john.ankotlin.R
import timber.log.Timber
import java.util.*

/**
 * https://github.com/385841539/HorizontalScrollSelectedView
 */
class HorizontalselectedView(mContext: Context?, attrs: AttributeSet?) :
    View(mContext, attrs) {
    private var strings: List<String> = ArrayList()//数据源字符串数组

    private var seeSize = 5//可见个数

    private var anInt: Int = 0//每个字母所占的大小；
    private var textPaint: TextPaint? = null
    private var firstVisible = true
    private var mWidth: Int = 0//控件宽度
    private var mHeight: Int = 0//控件高度
    private var selectedPaint: Paint? = null//被选中文字的画笔
    private var index: Int = 0
    private var downX: Float = 0.toFloat()
    private var anOffset: Float = 0.toFloat()
    private val selectedTextSize: Float
    private val selectedColor: Int
    private val textSize: Float
    private val textColor: Int
    private val rect = Rect()

    private var textWidth = 0
    private var textHeight = 0
    private var centerTextHeight = 0


    init {
        setWillNotDraw(false)
        isClickable = true

        val tta = context.obtainStyledAttributes(
            attrs,
            R.styleable.HorizontalselectedView
        )
        //两种字体颜色和字体大小
        seeSize = tta.getInteger(R.styleable.HorizontalselectedView_HorizontalselectedViewSeesize, 5)
        selectedTextSize = tta.getFloat(R.styleable.HorizontalselectedView_HorizontalselectedViewSelectedTextSize, 50f)
        selectedColor = tta.getColor(
            R.styleable.HorizontalselectedView_HorizontalselectedViewSelectedTextColor,
            context.resources.getColor(android.R.color.black)
        )
        textSize = tta.getFloat(R.styleable.HorizontalselectedView_HorizontalselectedViewTextSize, 40f)
        textColor = tta.getColor(
            R.styleable.HorizontalselectedView_HorizontalselectedViewTextColor,
            context.resources.getColor(android.R.color.darker_gray)
        )

        initPaint()//初始化画笔
    }

    private fun initPaint() {
        textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        textPaint!!.textSize = textSize
        textPaint!!.color = textColor
        selectedPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        selectedPaint!!.color = selectedColor
        selectedPaint!!.textSize = selectedTextSize
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (firstVisible) {
            mWidth = width
            mHeight = height
            anInt = width / seeSize
            firstVisible = false
        }
        val lPaint = Paint()
        lPaint.color =/* Color.parseColor("#D8D8D8")*/ Color.BLUE

//        canvas.drawLine(0f, 0f, mWidth.toFloat(), 0f, lPaint)
//        canvas.drawLine(0f, height.toFloat() - 100, width.toFloat(), height.toFloat(), lPaint)

        Timber.i("height$height width $mWidth  height $mHeight")

        if (index >= 0 && index <= strings.size - 1) {
            val s = strings[index]
            selectedPaint!!.getTextBounds(s, 0, s.length, rect)
            val centerTextWidth = rect.width()
            centerTextHeight = rect.height()
            canvas.drawText(
                strings[index],
                getWidth() / 2 - centerTextWidth / 2 + anOffset,
                (getHeight() / 2 + centerTextHeight / 2).toFloat(),
                selectedPaint!!
            )//绘制被选中文字，注意点是y坐标

            for (i in strings.indices) {//遍历strings，把每个地方都绘制出来，
                if (index > 0 && index < strings.size - 1) {//这里主要是因为strings数据源的文字长度不一样，为了让被选中两边文字距离中心宽度一样，我们取得左右两个文字长度的平均值
                    textPaint!!.getTextBounds(strings[index - 1], 0, strings[index - 1].length, rect)
                    val width1 = rect.width()
                    textPaint!!.getTextBounds(strings[index + 1], 0, strings[index + 1].length, rect)
                    val width2 = rect.width()
                    textWidth = (width1 + width2) / 2
                }
                if (i == 0) {//得到高，高度是一样的，所以无所谓
                    textPaint!!.getTextBounds(strings[0], 0, strings[0].length, rect)
                    textHeight = rect.height()
                }

                /**
                 * getWidth() / 2+(i - index) * anInt - textWidth / 2 + anOffset 每组文字得x坐标, anOffset先不考虑
                 * getWidth() / 2  中心点坐标
                 * (i - index) * anInt 向左或向右得坐标
                 * textWidth / 2   文字得宽度
                 */

                if (i != index) {
                    canvas.drawText(
                        strings[i],
                        (i - index) * anInt + getWidth() / 2 - textWidth / 2 + anOffset,
                        (getHeight() / 2 + textHeight / 2).toFloat(),
                        textPaint!!
                    )//画出每组文字
                }
            }
        }
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        Timber.i("action", "onTouchEvent: " + event.action)
        when (event.action) {
            MotionEvent.ACTION_DOWN -> downX = event.x //获得点下去的x坐标
            MotionEvent.ACTION_MOVE -> {
                val scrollX = event.x
                if (index != 0 && index != strings.size - 1) {
                    anOffset = scrollX - downX     //滑动时的偏移量，用于计算每个是数据源文字的坐标值
                } else {
                    anOffset = ((scrollX - downX) / 1.5).toFloat()
                }
                if (scrollX > downX) {
                    //向右滑动，当滑动距离大于每个单元的长度时，则改变被选中的文字。
                    if (scrollX - downX >= anInt) {
                        if (index > 0) {
                            anOffset = 0f
                            index = index - 1
                            downX = scrollX
                        }
                    }
                } else {
                    //向左滑动，当滑动距离大于每个单元的长度时，则改变被选中的文字。
                    if (downX - scrollX >= anInt) {
                        if (index < strings.size - 1) {
                            anOffset = 0f
                            index = index + 1
                            downX = scrollX
                        }
                    }
                }
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                anOffset = 0f
                invalidate()
            }
        }
        return super.onTouchEvent(event)
    }

    /**
     * 获得被选中的文本
     *
     * @return 被选中的文本
     */
    fun getSelectedString(): String {
        if (strings.size != 0) {
            return strings[index]
        }
        return ""
    }

    /**
     * 改变中间可见文字的数目
     *
     * @param seeSizes 可见数
     */
    fun setSeeSize(seeSizes: Int) {
        if (seeSize > 0) {
            seeSize = seeSizes
            invalidate()
        }

    }


    /**
     * 向左移动一个单元
     */
    fun setAnLeftOffset() {
        if (index < strings.size - 1) {
            index = index + 1
            invalidate()
        }

    }

    /**
     * 向右移动一个单元
     */
    fun setAnRightOffset() {
        if (index > 0) {
            index = index - 1
            invalidate()
        }
    }

    /**
     * 设置个数据源
     *
     * @param strings 数据源String集合
     */
    fun setData(strings: List<String>) {
        this.strings = strings
        index = strings.size / 2
        invalidate()
    }
}
