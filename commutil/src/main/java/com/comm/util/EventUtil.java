package com.comm.util;

import android.view.View;

import timber.log.Timber;

/**
 * @author : John
 * @date : 2018/10/16
 * https://blog.csdn.net/zhufuing/article/details/53021835
 */
public abstract class EventUtil implements View.OnClickListener {
    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private static final int MIN_CLICK_DELAY_TIME = 800;
    private static long lastClickTime;


    public static boolean isFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = curClickTime;
        return flag;
    }


    public static boolean isPatient() {
        if ("com.casanube.patient".equals(AppUtil.getApp().getPackageName())) {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        boolean isFatt = isFastClick();
        Timber.i("isFatt    " + isFatt);
        if (isFatt) {
            onEventClick(v);
        }
    }

    protected abstract void onEventClick(View v);
}

