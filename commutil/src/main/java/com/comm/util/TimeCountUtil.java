package com.comm.util;

import android.os.Handler;
import android.os.Message;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author : John
 * @date : 2018/9/2
 */
public class TimeCountUtil {
    //    private static final TimeCountUtil ourInstance = new TimeCountUtil();
    private final Timer timer;
    int cnt = 0;
    private TimerTask timerTask;
    private Handler handler;


    public TimeCountUtil(Handler handler) {
        timer = new Timer();
        this.handler = handler;
    }

    public void start() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                String txtc = getStringTime(cnt++);
                Message message = new Message();
                message.obj = txtc;
                handler.sendMessage(message);
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    private String getStringTime(int cnt) {
        int min = cnt % 3600 / 60;
        int second = cnt % 60;
        return String.format(Locale.CHINA, "%02d:%02d", min, second);
    }

    public void startSecond() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                String txtc = getStringSecond(cnt++);
                Message message = new Message();
                message.obj = txtc;
                handler.sendMessage(message);
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    private String getStringSecond(int cnt) {
        int min = cnt % 3600 / 60;
        int second = cnt % 60;
        return String.format(Locale.CHINA, "%2d", second);
    }

    public void stop() {
        if (timerTask != null && !timerTask.cancel()) {
            timerTask.cancel();
            timer.cancel();
            cnt = 0;
        }
    }
}
