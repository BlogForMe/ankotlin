package com.john.kot.viewgroup.view

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup

//  https://www.bilibili.com/video/BV1M54y1y79P?from=search&seid=18028227823566625572&spm_id_from=333.337.0.0
class FlowLayout : ViewGroup {
    var TAG = "FlowLayout"
    private val mHorizontalSpacing = dp2px(16) // 每个item横向间接
    private val mVerticalSpacing = dp2px(16) // 每个item横向间接
    private var allLines //记录所有的行，一行一行的存储，用于layout
            : MutableList<List<View>>? = null
    var lineHeights: MutableList<Int> = ArrayList() //记录每一行的行高,用于layout

    constructor(context: Context?) : super(context) {}

    //反射
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}

    //主题
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    private fun initMeasureParams() {
        allLines = ArrayList()
        lineHeights = ArrayList()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //必须在这里初始化，如果放构造函数，只会初始化一次,但是这里每次都需要重置这个值
        //但是父ViewGroup的可以在onLayout()或其他方法，调用chiliView的onMeasure()就比如这里.
        // 所以每次onMeasure，onLayout用到的值都不能在构造方法里面初始化。
        initMeasureParams()

        val selfWidth = MeasureSpec.getSize(widthMeasureSpec) //ViewGroup解析父亲给了的宽度
        val selfHeight = MeasureSpec.getSize(heightMeasureSpec)
        var lineViews = ArrayList<View>() // 保留横向 一行中的所的view
        var lineWidthUsed = 0 // 记录这行已经使用了多宽的size
        var lineHeight = 0 // 一行的行高

        var parentNeededWidth = 0 // measure过程中，子View要求的父ViewGroup的宽
        var parentNeededHeight = 0 // measure过程中，子View要求的父ViewGroup的高
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            val childLp = childView.layoutParams
            //  paddingLeft + paddingRight 是parent view的padding
            val childWidthMeasureSpec =
                getChildMeasureSpec(
                    widthMeasureSpec,
                    paddingLeft + paddingRight,
                    childLp.width
                )//widthMeasureSpec也是parent的，得到child的MeasureSpec
            val childHeightMeasureSpec =
                getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childLp.height)

            /**
             *   1. 根据childMeasureSpec测量 子view。
             *   接下来就可以得到 child view宽高
             */

            childView.measure(
                childWidthMeasureSpec,
                childHeightMeasureSpec
            )

            //度量child View 宽高
            val childMeasuredWidth = childView.measuredWidth
            val childMeasuredHeight = childView.measuredHeight


            /**
             * 2. 度量parent view size
             * 宽度是流式布局 最宽的宽度
             * 高度是整个流式布局的高度
             */

            // new child View  +  had used width + mHorizontalSpacing
            if (childMeasuredWidth + lineWidthUsed + mHorizontalSpacing > selfWidth) {  //如果需要换行
                allLines!!.add(lineViews)
                lineHeights.add(lineHeight)

                //一旦换行，我们就可以计算需要的 parent view width height，所以此时要记录下来
                parentNeededHeight += lineHeight + mVerticalSpacing

                //新加入一行，看哪一行更宽，作为view的宽度。
                parentNeededWidth = Math.max(
                    parentNeededWidth,// 之前所有行里最大的宽度
                    lineWidthUsed + mHorizontalSpacing // 当前行的宽度
                )
                lineViews = ArrayList()
                lineWidthUsed = 0
                lineHeight = 0
            }
            if (i == childCount - 1 /*&&lineWidthUsed==selfWidth*/) {
                allLines!!.add(lineViews)
                lineHeights.add(lineHeight)
                parentNeededWidth = Math.max(parentNeededWidth, lineWidthUsed)
                parentNeededHeight += lineHeight + mVerticalSpacing
            }


            //view是分行layout，所以要记录每一行有哪些view,这样可以方便layout布局
            lineViews.add(childView)

            // lineWidthUsed：之前用了宽度 + childMeasuredWidth：新加入的节点 + mHorizontanSpacing：间距
            lineWidthUsed += childMeasuredWidth + mHorizontalSpacing
            lineHeight = lineHeight.coerceAtLeast(childMeasuredHeight) //取一行里 最高的控件高度
        }



        //根据子view的度量结果，来重新度量自己ViewGroup
        //作为一个ViewGroup,它自己也是一个View,它的大小也许有根据它的父亲给它提供的宽高来度量
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)



        /**
         * 选择流式布局 宽度最宽的作为自己的宽度
         * 选择流式布局所有高度之和，作为自己的高度
         */
        val realWidth = if (widthMode == MeasureSpec.EXACTLY) selfWidth else parentNeededWidth // viewgroup给的EXACTLY的Size，就用EXACTLY的Size，否则根据子view来，这是我的理解
        val realHeight = if (heightMode == MeasureSpec.EXACTLY) selfHeight else parentNeededHeight


        setMeasuredDimension(realWidth, realHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val lineCount = allLines!!.size // 获取layout中的行数
        var curL = paddingLeft
        var curT = paddingTop
        for (i in 0 until lineCount) {
            val lineViews = allLines!![i]
            val lineHeight = lineHeights[i]
            for (j in lineViews.indices) {
                val view = lineViews[j]
                val left = curL
                val top = curT

//                int right = left + view.getMeasuredWidth(); 在view.layout()过程结束后才能获取到,第一次获取不到值，所以不用
                val right = left + view.measuredWidth
                val bottom = top + view.measuredHeight
                view.layout(left, top, right, bottom)
                curL = right + mHorizontalSpacing
            }
            curL = paddingLeft // 第二行从新开始
            curT = curT + lineHeight + mVerticalSpacing
            Log.i(TAG, "onLayout: curL $curL curT $curT")
        }
    }

    companion object {
        fun dp2px(dp: Int): Int {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp.toFloat(),
                Resources.getSystem().displayMetrics
            ).toInt()
        }
    }
}