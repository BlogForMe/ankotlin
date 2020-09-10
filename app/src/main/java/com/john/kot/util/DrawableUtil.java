package com.john.kot.util;

import android.graphics.drawable.GradientDrawable;
import android.view.View;

import androidx.databinding.BindingAdapter;

public class DrawableUtil {
    @BindingAdapter(value = {"drawable_solidColor", "drawable_radius"}, requireAll = false)
    public static void setViewBackground(View view, int color, int radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(color);
        drawable.setCornerRadius(radius);
        view.setBackground(drawable);

    }

}
