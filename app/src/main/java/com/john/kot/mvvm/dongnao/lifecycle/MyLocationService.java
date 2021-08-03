package com.john.kot.mvvm.dongnao.lifecycle;

import android.util.Log;

import androidx.lifecycle.LifecycleService;

public class MyLocationService  extends LifecycleService {
    String TAG = "MyLocationService";
    public MyLocationService(){
        Log.d(TAG, "MyLocationService: ");
        MyLocationObserver observer = new MyLocationObserver();
        getLifecycle().addObserver(observer);
    }

}
