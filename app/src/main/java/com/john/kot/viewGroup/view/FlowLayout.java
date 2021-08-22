package com.john.kot.viewGroup.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    String TAG = "FlowLayout";
    private int mHorizontalSpacing = dp2px(16); // 每个item横向间接
    private int mVerticalSpacing = dp2px(16); // 每个item横向间接

    private List<List<View>> allLines;//记录所有的行，一行一行的存储，用于layout
    List<Integer> lineHeights = new ArrayList<>();//记录每一行的行高,用于layout

    public FlowLayout(Context context) {
        super(context);
    }

    // 反射
    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //主题style
    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initMeasureParams(){
        allLines = new ArrayList<>();
        lineHeights = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //必须在这里初始化，如果放构造函数，那么其他方法可能跑很多次，导致这里初始化后的值不准确。
        // 所以每次onMeasure，onLayout用到的值都不能在构造方法里面初始化。
        initMeasureParams();
        /**
         *  度量孩子
         */

        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int selfWidth = MeasureSpec.getSize(widthMeasureSpec);//ViewGroup解析的宽度, 父亲给了的宽度
        int selfHeight = MeasureSpec.getSize(heightMeasureSpec);// ViewGroup解析的高度

        ArrayList<View> lineViews = new ArrayList<>();// 保留横向 一行中的所的view

        int lineWidthUsed = 0; // 记录这行已经使用了多宽的size
        int lineHeight = 0;    // 一行的行高

        int parentNeededWidth = 0; // measure过程中，子View要求的父ViewGroup的宽
        int parentNeededHeight = 0; // measure过程中，子View要求的父ViewGroup的高

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);

            // lp包含了xml文件里的layout_打头的参数的对应值
            // lp.width: 对应 layout_width的值，而且是转换过的值。
            // lp.height:对应 layout_height
            // wrap_content => WRAP_CONTENT
            // match_parent => MATCH_PARENT
            // xxdp / xxsp => 具体的像素值
            LayoutParams childLp = childView.getLayoutParams();
            // padding是父view的padding,在这里也就是 paddingLeft + paddingRight, widthMeasureSpec也是父亲的
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childLp.width);
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childLp.height);
            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec);// 根据childMeasureSpec测量子view

            //获取子view的宽高
            int childMeasuredWidth = childView.getMeasuredWidth();
            int childMeasuredHeight = childView.getMeasuredHeight();


            //通过宽度来判断是否需要换行，通过换行后的每行的行高来获取整个 viewGroup的行高
            //如果需要换行
            if (childMeasuredWidth + lineWidthUsed + mHorizontalSpacing > selfWidth) {
                allLines.add(lineViews);
                lineHeights.add(lineHeight);

                //一旦换行，我们就可以判断当前行需要的宽和高，所以此时要记录下来
                parentNeededHeight = parentNeededHeight + lineHeight + mVerticalSpacing;
                parentNeededWidth = Math.max(parentNeededWidth, lineWidthUsed + mHorizontalSpacing);//新加入一行，看哪一行更宽，作为view的宽度。

                lineViews = new ArrayList<>();
                lineWidthUsed = 0;
                lineHeight = 0;
            }

            if((i==(childCount-1))/*&&lineWidthUsed==selfWidth*/){
                allLines.add(lineViews);
                lineHeights.add(lineHeight);
                parentNeededWidth = Math.max(parentNeededWidth,lineWidthUsed);
                parentNeededHeight = parentNeededHeight + lineHeight + mVerticalSpacing;
            }



            //view是分行layout，所以要记录每一行有哪些view,这样可以方便layout布局
            lineViews.add(childView);


            //每行都会有自己的宽和高
            lineWidthUsed = lineWidthUsed + childMeasuredWidth + mHorizontalSpacing;  // lineWidthUsed：之前用了宽度 + childMeasuredWidth：新加入的节点 + mHorizontanSpacing：间接
            lineHeight = Math.max(lineHeight, childMeasuredHeight); //取一行里 最高的高度
        }
        //根据子view的度量结果，来重新度量自己ViewGroup
        //作为一个ViewGroup,它自己也是一个View,它的大小也许有根据它的父亲给它提供的宽高来度量
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        /**
         *  选择流式布局 宽度最宽的作为自己的宽度
         *  选择流式布局所有高度之和，作为自己的高度
         */
        int realWidth = (widthMode == MeasureSpec.EXACTLY) ? selfWidth : parentNeededWidth;
        int realHeight = (heightMode == MeasureSpec.EXACTLY) ? selfHeight : parentNeededHeight;

        /**
         * 度量自己
         */
        setMeasuredDimension(realWidth, realHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int lineCount = allLines.size();// 获取layout中的行数

        int curL = getPaddingLeft();
        int curT = getPaddingTop();
        for (int i = 0; i < lineCount; i++) {
            List<View> lineViews = allLines.get(i);
            Integer lineHeight = lineHeights.get(i);
            for (int j = 0; j < lineViews.size(); j++) {
                View view = lineViews.get(j);
                int left = curL;
                int top = curT;

//                int right = left + view.getMeasuredWidth(); 在view.layout()过程结束后才能获取到,第一次获取不到值，所以不用

                int right = left + view.getMeasuredWidth();
                int bottom = top + view.getMeasuredHeight();
                view.layout(left, top, right, bottom);
                curL= right+mHorizontalSpacing;
            }
            curL = getPaddingLeft(); // 第二行从新开始
            curT = curT + lineHeight + mVerticalSpacing;
            Log.i(TAG, "onLayout: curL " + curL + " curT " + curT);
        }
    }

    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
