package com.kot.mvvm.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

internal  // Glide doesn't support Java 8
class LifecycleLifecycle : LifecycleObserver {
    val TAG = "LifecycleLifecycle"


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun whenON_CREATE() {
        Log.d(TAG, "ON_CREATE: ")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun whenON_START() {
        Log.d(TAG, "ON_START: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun whenON_RESUME() {
        Log.d(TAG, "ON_RESUME: ")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun whenON_STOP() {
        Log.d(TAG, "ON_STOP: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun whenON_DESTROY() {
        Log.d(TAG, "ON_DESTROY: ")
    }


}
