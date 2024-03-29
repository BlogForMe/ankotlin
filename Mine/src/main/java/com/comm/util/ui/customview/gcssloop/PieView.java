package com.comm.util.ui.customview.gcssloop;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import timber.log.Timber;

/**
 * http://www.gcssloop.com/customview/Canvas_BasicGraphics
 */
public class PieView extends View {

    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private final int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000,
        0xFFFF8C69, 0xFF808080,
        0xFFE6B800, 0xFF7CFC00};
    private final Paint mPaint = new Paint();
    private float mStartAngle = 0;
    private ArrayList<PieData> mData;
    private int mWidth, mHeigth;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeigth = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData) {return;}
        float currentStartAngle = mStartAngle;// 当前起始角度
        canvas.translate(mWidth / 2, mHeigth / 2);  //移动圆心
        float r = (float)(Math.min(mWidth, mHeigth) / 2 * 0.8); //饼状图半径
        RectF rectF = new RectF(-r, -r, r, r);  //饼状图绘制区域
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rectF, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();
        }
    }

    // 设置起始角度
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();
    }

    //设置数据
    public void setData(ArrayList<PieData> mData) {
        this.mData = mData;
        initData(mData);
    }

    private void initData(ArrayList<PieData> mData) {
        if (null == mData || mData.size() == 0) //数据有问题 直接返回
        {return;}
        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            sumValue += pie.getValue(); //计算数值和
            int j = i % mColors.length;
            pie.setColor(mColors[j]);
        }
        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            float percentage = pie.getValue() / sumValue; //百分比
            float angle = percentage * 360;                 //对应的角度

            pie.setPercentage(percentage);
            pie.setAngle(angle);
            sumAngle += angle;
            Timber.i("angle " + pie.getAngle());
        }
    }

}
