package com.android.util;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by A on 2018/3/30.
 */

public class CustomCountTimer extends CountDownTimer {

    private String apendTxt;
    private String reSendTxt;


    private TextView tvSms;

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
    }


    @Override
    public void onTick(long millisUntilFinished) {
        tvSms.setText((millisUntilFinished / 1000) + apendTxt);
        tvSms.setEnabled(false);
        tvSms.setTextColor(Color.GRAY);
    }

    @Override
    public void onFinish() {
        tvSms.setEnabled(true);
        tvSms.setTextColor(Color.parseColor("#FAC742"));
        tvSms.setText(reSendTxt);
    }

    public CustomCountTimer apendTxt(String apendTxt) {
        this.apendTxt = apendTxt;
        return this;
    }

    public CustomCountTimer reSendTxt(String reSendTxt) {
        this.reSendTxt = reSendTxt;
        return this;
    }



}
