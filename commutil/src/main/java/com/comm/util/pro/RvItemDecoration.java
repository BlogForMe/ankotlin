package com.comm.util.pro;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by jon on 17-11-15.
 * RecycleView 线
 */

public class RvItemDecoration extends RecyclerView.ItemDecoration {
    private final Drawable mDivider;
    private Context context;
    private int mOrientation;

    static final int[] ARTTS = new int[]{android.R.attr.listDivider};

    public RvItemDecoration(Context context) {
        this.context = context;
        TypedArray ta = context.obtainStyledAttributes(ARTTS);
        this.mDivider = ta.getDrawable(0);
        ta.recycle();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, 1);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        drawVerticalLine(c, parent, state);
    }


    //画横线, 这里的parent其实是显示在屏幕显示的这部分
    private void drawVerticalLine(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount-1; i++) {
            View child = parent.getChildAt(i);
            //获得child的布局信息　
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left+40, top, right, bottom);  //矩形的位置是根据坐标来确定的
            mDivider.draw(c);
        }
    }
}
