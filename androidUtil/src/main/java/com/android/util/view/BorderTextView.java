package com.android.util.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.android.util.R;


/**
 * https://www.jianshu.com/p/067f3ea26e5a
 * <p>
 * https://github.com/FmrChina/SpeedyTextView
 * 圆角矩形 不同颜色的
 */
public class BorderTextView extends AppCompatTextView {

    private int normalColor;   // 背景颜色
    private int selectColor = Color.parseColor("#ff0011");   // 按下背景颜色
    private int cornerRadius;   // 圆角半径
    private Paint mPaint = new Paint();
    private RectF mRectF = new RectF();

    private float topLeft, topRight, bottomLeft, bottomRight;

    public BorderTextView(Context context) {
        this(context, null);
    }

    public BorderTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BorderTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BorderTextView);
        selectColor = ta.getColor(R.styleable.BorderTextView_contentBackColor,context.getResources().getColor(android.R.color.white));
        cornerRadius = ta.getDimensionPixelSize(R.styleable.BorderTextView_cornerRadius, 0);
        topLeft = ta.getDimensionPixelSize(R.styleable.BorderTextView_topLeft, 0);
        topRight = ta.getDimensionPixelSize(R.styleable.BorderTextView_topRight, 0);
        bottomLeft = ta.getDimensionPixelSize(R.styleable.BorderTextView_bottomLeft, 0);
        bottomRight = ta.getDimensionPixelSize(R.styleable.BorderTextView_bottomRight, 0);
        ta.recycle();
        initView();
    }

    private void initView() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        build();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mRectF.left = mRectF.top = 0.5f;
//        mRectF.right = getMeasuredWidth() - 0.5f;
//        mRectF.bottom = getMeasuredHeight() - 0.5f;
//        canvas.drawRoundRect(mRectF,cornerRadius,cornerRadius,mPaint);
    }


    private static GradientDrawable getDrawable(int normalColor, int radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(radius);//设置4个角的弧度
        drawable.setColor(normalColor);   //// 设置颜色
//        StateListDrawable drawable = new StateListDrawable();
//        drawable.addState(new int[]{android.R.attr.state_enabled},drawable); // 默认状态,默认状态下的图片
        return drawable;
    }

    private GradientDrawable getDrawable(float topLeft, float topRigth, float bottomLeft, float bottomRight, int contentColor, int storkeWidth, int strokeColor) {
        GradientDrawable drawable = new GradientDrawable();
        //top-left, top-right, bottom-right, bottom-left
        float[] radius = new float[]{topLeft, topLeft, topRigth, topRigth, bottomRight, bottomRight, bottomLeft, bottomLeft};
        //这个方法传入的数组长度必须是 > = 8 否则会抛数值下标越界  数组值分别对应 top-left, top-right, bottom-right, bottom-left
        drawable.setCornerRadii(radius);
        drawable.setColor(contentColor);
        drawable.setStroke(storkeWidth, strokeColor);
        return drawable;
    }

    /**
     * 设置背景选择器
     *
     * @param normalDraw
     * @param pressedDraw
     * @return stateListDrawable
     */
    private StateListDrawable getSelector(Drawable normalDraw, Drawable pressedDraw) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDraw);
        stateListDrawable.addState(new int[]{}, normalDraw);
        return stateListDrawable;
    }

    private StateListDrawable getSelector(Drawable normalDraw) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{}, normalDraw);
        return stateListDrawable;
    }
//    public void setContentColorResource(int colorResource) {
//        try {
//            contentColor = ContextCompat.getColor(getContext(), colorResource);
//            setBackground(getDrawable());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    private void setSelect(int contentColor, int cornerRadius, float topLeft, float topRight, float bottomLeft, float bottomRight) {
        int textColor = getCurrentTextColor();
        GradientDrawable normal = null;
        if (cornerRadius == 0) {
            normal = getDrawable(topLeft, topRight, bottomLeft, bottomRight, contentColor, selectColor, cornerRadius);
        } else {
            normal = getDrawable(contentColor, cornerRadius);
        }
        setBackground(normal);

//        //没有设置点击背景色，表示不设置Selector 只设置Draw
//        if (bgClickColor != 0) {
//            StateListDrawable selector = getSelector(normal, press);
//            setBackground(selector);
//        } else {
//            setBackground(normal);
//        }
    }

    public void build() {
        setSelect(selectColor, cornerRadius, topLeft, topRight, bottomLeft, bottomRight);
    }


    public BorderTextView setContentColor(int contentColor) {
        this.selectColor = contentColor;
        build();
        return this;
    }
}
