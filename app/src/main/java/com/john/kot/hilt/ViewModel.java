/**
 * ClassName:      ViewModel
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/26 10:59 AM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/26 10:59 AM
 * UpdateRemark:   Modify the description
 */
package com.john.kot.hilt;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

// 已经绑定的类
public class ViewModel {
    String TAG = "ViewModel";
    User1 user;
    Application application;
    Activity activity;

    @Inject
    public ViewModel(User1 user, Application application, Activity activity) {
        this.user = user;
        this.application = application;
        this.activity = activity;
    }

    public void  test(){
        Log.i(TAG, "test:user "+user);
        Log.i(TAG, "test: application "+application);
        Log.i(TAG, "test: activity"+activity);
    }
}
