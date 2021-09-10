package com.john.kot

import android.app.Application
import com.android.util.AppUtil
import com.android.util.ToastUtil
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree

@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ToastUtil.register(this)
        AppUtil.init(this)
        Timber.plant(DebugTree())
    }
}