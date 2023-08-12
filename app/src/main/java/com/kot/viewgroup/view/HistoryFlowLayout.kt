/**
 *
 * ClassName:      HistoryFlowLayout
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/12/2 8:20 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/12/2 8:20 PM
 * UpdateRemark:   Modify the description
 */

package com.kot.viewgroup.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class HistoryFlowLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ViewGroup(context, attrs, defStyleAttr) {

    private var lineHeights: ArrayList<Int>? = null
    private var allLinesViews: ArrayList<List<View>>? = null
    private val mHorizontalSpacing = FlowLayout.dp2px(16) // 每个item横向间隔
    private val mVerticalSpacing = FlowLayout.dp2px(16) // 每个item众向间隔

    private var aLineViews: ArrayList<View>? = null


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        allLinesViews = ArrayList()
        lineHeights = ArrayList()

        val selfWidth = MeasureSpec.getSize(widthMeasureSpec) // parent留的width
        val selfHeight = MeasureSpec.getSize(heightMeasureSpec)

        var curLineUsedWidth = 0
        var curLineHeight = 0 // 一行的行高

        var parentNeedWidth = 0 // measure过程中，子View要求的父ViewGroup的宽

        var parentNeedHeight = 0 // measure过程中，子View要求的父ViewGroup的高


        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            val childLp = childView.layoutParams
            val childWidthMeasureSpec =
                getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childLp.width)
            val childHeightMeasureSpec =
                getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childLp.height)
            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec)

            val childMeasuredWidth = childView.measuredWidth
            val childMeasuredHeight = childView.measuredHeight

            if (childMeasuredWidth + curLineUsedWidth + mHorizontalSpacing > selfWidth) {
                aLineViews?.let { allLinesViews?.add(it) }
                lineHeights?.add(curLineHeight)

                parentNeedHeight += curLineHeight + mVerticalSpacing
                parentNeedWidth =
                    Math.max(parentNeedWidth, curLineUsedWidth + mHorizontalSpacing)

                aLineViews = ArrayList()
                curLineUsedWidth = 0
                curLineHeight = 0;
            }
            if (i == childCount - 1) {
                aLineViews?.let { allLinesViews?.add(it) }
                lineHeights?.add(curLineHeight)
                parentNeedWidth = parentNeedWidth.coerceAtLeast(curLineUsedWidth)
                parentNeedHeight += curLineHeight + mVerticalSpacing
            }
            aLineViews?.add(childView)

            curLineUsedWidth += childMeasuredWidth + mHorizontalSpacing
            curLineHeight = curLineHeight.coerceAtLeast(childMeasuredHeight)

            val widthMode = MeasureSpec.getMode(widthMeasureSpec)
            val heightMode = MeasureSpec.getMode(heightMeasureSpec)

            val realWidth = if (widthMode == MeasureSpec.EXACTLY) selfWidth else parentNeedWidth
            val realHeight = if (heightMode == MeasureSpec.EXACTLY) selfHeight else parentNeedHeight
            setMeasuredDimension(realWidth, realHeight)

        }

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var curLeft = paddingLeft
        var curTop = paddingTop
        allLinesViews?.let {
            for ((index, lineViews) in it.withIndex()) {
                lineViews.forEach { view ->
                    val left = curLeft
                    val top = curTop
                    val right = left + view.measuredWidth
                    val bottom = top + view.measuredHeight
                    view.layout(left, top, right, bottom)
                }
                curLeft = paddingLeft
                lineHeights?.let {
                    curTop += it[index] + mVerticalSpacing
                }
            }
        }

    }

}