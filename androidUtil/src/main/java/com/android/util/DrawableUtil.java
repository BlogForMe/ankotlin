package com.android.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.TextView;

/**
 * @author : John
 * @date : 2018/8/30
 */
public class DrawableUtil {
    public static void setDrawableLeft(TextView textView, Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    public static void setDrawableTop(TextView textView, Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    public static Drawable getPressedSelector(int enableColor,int normalColor,int pressedColor,int radius){
        Drawable normal = createShape(normalColor,radius);
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_enabled},normal); // 默认状态,默认状态下的图片
        return drawable;
    }

    private static Drawable createShape(int color, int radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(radius);//设置4个角的弧度
        drawable.setColor(color);   //// 设置颜色
        return drawable;
    }
}
