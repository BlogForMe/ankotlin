package com.john.kot.ui.elec;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.john.kot.R;

/**
 * https://blog.csdn.net/qingsheng33/article/details/77933977
 */
public class ReportView extends View {
    private Paint mPaint;
    private float widthOfSmallGird;//每个小格宽度
    private String TAG = getClass().getSimpleName();

    protected float stepx = 0.154f;
    private int width;
    private float baseLine;
    private float height;

    public ReportView(Context context) {
        this(context, null);
    }

    public ReportView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.elec_color));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        widthOfSmallGird = width / (25 * 5);
        height = widthOfSmallGird * 5 * 8;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        baseLine = height / 2f;                // 基准线位于中间
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 第1组: moveTo
         */
        Path path = new Path();
        if (datas != null) {
            for (int i = 0; i < datas.size(); i++) {
                if (i == 0) {
                    path.moveTo(i * stepx, getYPx(datas.get(i)));
                } else {
                    path.lineTo(i * stepx, getYPx(datas.get(i)));
                }
                Log.i(TAG, "i*stepx    " + i * stepx + "    datas.get(i)    " + datas.get(i) + "    y  " + getYPx(datas.get(i)));
            }
//        path.close();  //形成封闭的图形
            canvas.drawPath(path, mPaint);
        }

    }

    public float getYPx(float data) {
        if (baseLine < Math.abs(data * 10 * 5)) {
            if (data < 0) {
                return -2 * baseLine;
            } else {
                return 2 * baseLine;
            }
        }
        return baseLine - data * 10 * 5;
    }

    private float mathTwo(float data) {
        return (float) (Math.round(data * 100) / 100);
    }


    private List<Float> datas;

    public void setData(List<Float> data) {
        datas = data;
        invalidate();
    }

}
