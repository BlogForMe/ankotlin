package com.android.util;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by A on 2018/3/30.
 */

public class CustomCountTimer extends CountDownTimer {
    private TextView tvSms;
    private Context mContext;
    private Handler handler;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public CustomCountTimer(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture, countDownInterval);
        this.tvSms = textView;
        mContext = AppUtil.getApp();
    }

    public CustomCountTimer(long millisInFuture, long countDownInterval, TextView textView, Context context, Handler handler) {
        super(millisInFuture, countDownInterval);
        this.tvSms = textView;
        mContext = context;
        this.handler = handler;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        tvSms.setText((millisUntilFinished / 1000) + " 秒后重发");
        tvSms.setEnabled(false);
        tvSms.setTextColor(Color.GRAY);
    }

    @Override
    public void onFinish() {
        tvSms.setEnabled(true);
//        tvSms.setTextColor(mContext.getResources().getColor(R.color.text_green_color));
        tvSms.setText("重新发送验证码");
        handler.sendEmptyMessage(0);
    }



}
