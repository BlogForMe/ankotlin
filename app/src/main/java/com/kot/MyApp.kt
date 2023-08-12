package com.kot

import android.app.Application
import android.util.Log
import com.android.util.AppUtil
import com.android.util.ToastUtil
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree

@HiltAndroidApp // 1.  HiltAndroidApp注解 ,生成相应的组件
class MyApp : Application() {
    private val TAG = javaClass.simpleName
    override fun onCreate() {
        super.onCreate()
        ToastUtil.register(this)
        AppUtil.init(this)
        Timber.plant(DebugTree())
        Log.i(TAG, "onCreate: ${javaClass.superclass.simpleName}")
    }
}