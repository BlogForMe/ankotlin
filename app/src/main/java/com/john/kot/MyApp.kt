package com.john.kot

import android.app.Application
import com.android.util.AppUtil
import com.android.util.ToastUtil
import timber.log.Timber



class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ToastUtil.register(this)
        AppUtil.init(this)
    }
}