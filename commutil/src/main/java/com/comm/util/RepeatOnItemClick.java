package com.comm.util;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import timber.log.Timber;

public abstract class RepeatOnItemClick implements BaseQuickAdapter.OnItemClickListener {
    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private static final int MIN_CLICK_DELAY_TIME = 300;
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


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        boolean isFatt = isFastClick();
        Timber.i("isFatt    " + isFatt);
        if (isFatt) {
            onReItemClick(adapter, view, position);
        }
    }

   public   abstract void onReItemClick(BaseQuickAdapter adapter, View view, int position);


}
