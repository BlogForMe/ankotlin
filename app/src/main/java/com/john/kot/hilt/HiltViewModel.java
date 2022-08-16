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
import android.content.Context;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

import dagger.hilt.android.qualifiers.ApplicationContext;

// 已经绑定的类
public class HiltViewModel extends ViewModel {
    String TAG = "MainViewModel";

    User3 user;
    Application application;
    Activity activity;

    Context context;

    @ViewModelInject
    public HiltViewModel(User3 user, Application application, Activity activity,@ApplicationContext  Context context) {
        this.user = user;
        this.application = application;
        this.activity = activity;
        this.context =context;
    }

    public void  test(){
        Log.i(TAG, "test:user="+user);
        Log.i(TAG, "test: application="+application);
        Log.i(TAG, "test: activity="+activity);
        Log.i(TAG, "test: context="+context);
    }
}
