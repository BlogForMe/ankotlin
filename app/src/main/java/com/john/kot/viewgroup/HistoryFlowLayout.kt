package com.john.kot.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class HistoryFlowLayout : ViewGroup {
    var TAG = "HistoryFlowLayout"
    private val mHorizontalSpacing = 8// 每个item横向间接
    private val mVerticalSpacing = 8
    private var allLines
            : MutableList<List<View>>? = null
    var lineHeights: MutableList<Int> = ArrayList() //记录每一行的行高,用于layout

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private fun initMeasureParams() {
        allLines = ArrayList()
        lineHeights = ArrayList()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        initMeasureParams()
        /**
         * 度量孩子
         */
        val selfWidth = MeasureSpec.getSize(widthMeasureSpec) //ViewGroup解析的宽度, 父亲给了的宽度
        val selfHeight = MeasureSpec.getSize(heightMeasureSpec)
        var lineViews = ArrayList<View>() // 保留横向 一行中的所的view
        var lineWidthUsed = 0 // 记录这行已经使用了多宽的size
        var lineHeight = 0 // 一行的行高
        var parentNeededWidth = 0 // measure过程中，子View要求的父ViewGroup的宽
        var parentNeededHeight = 0
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            val childLp = childView.layoutParams
            // padding是父view的padding,在这里也就是 paddingLeft + paddingRight, widthMeasureSpec也是父亲的
            val childWidthMeasureSpec =
                getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childLp.width)
            val childHeightMeasureSpec =
                getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childLp.height)
            childView.measure(
                childWidthMeasureSpec,
                childHeightMeasureSpec
            )

            //获取子view的宽高
            val childMeasuredWidth = childView.measuredWidth
            val childMeasuredHeight = childView.measuredHeight


            if (childMeasuredWidth + lineWidthUsed + mHorizontalSpacing > selfWidth) {
                allLines?.add(lineViews)
                lineHeights.add(lineHeight)

                parentNeededHeight += lineHeight + mVerticalSpacing
                parentNeededWidth =
                    parentNeededWidth.coerceAtLeast(lineWidthUsed + mHorizontalSpacing) //新加入一行，看哪一行更宽，作为view的宽度。

                lineViews = ArrayList()
                lineWidthUsed = 0
                lineHeight = 0
            }
            lineViews.add(childView)
            lineWidthUsed += childMeasuredWidth + mHorizontalSpacing
            lineHeight = lineHeight.coerceAtLeast(childMeasuredHeight) //取一行里 最高的高度
            if (i == childCount - 1) {
                allLines?.add(lineViews)
                lineHeights.add(lineHeight)
                parentNeededWidth = parentNeededWidth.coerceAtLeast(lineWidthUsed)
                parentNeededHeight += lineHeight + mVerticalSpacing
            }
        }
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        val realWidth = if (widthMode == MeasureSpec.EXACTLY) selfWidth else parentNeededWidth
        val realHeight = if (heightMode == MeasureSpec.EXACTLY) selfHeight else parentNeededHeight
        /**
         * 度量自己
         */
        setMeasuredDimension(realWidth, realHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        if (allLines.isNullOrEmpty()) return
        val lineCount = allLines?.size ?: return
        var curL = paddingLeft
        var curT = paddingTop
        for (i in 0 until lineCount) {
            val lineViews = allLines?.getOrNull(i) ?: return
            val lineHeight = lineHeights[i]
            for (j in lineViews.indices) {
                val view = lineViews[j]
                val left = curL
                val top = curT

                val right = left + view.measuredWidth
                val bottom = top + view.measuredHeight
                view.layout(left, top, right, bottom)
                curL = right + mHorizontalSpacing
            }
            curL = paddingLeft
            curT += lineHeight + mVerticalSpacing
        }
    }

}