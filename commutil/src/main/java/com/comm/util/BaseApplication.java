package com.comm.util;

import android.app.Application;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtil.init(this);
    }
}
