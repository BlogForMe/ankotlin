package com.android.util;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AnimViewUtil {
    public static void startAnim(TextView textView, int resAnim) {
        Animation translateAnimation = AnimationUtils.loadAnimation(AppUtil.getApp(), resAnim);
        textView.startAnimation(translateAnimation);
    }

}
