package com.kot.mvvm.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.john.kot.R

class LifeCycleActivity : AppCompatActivity(), LifecycleOwner {
    val TAG = "LifeCycleActivity";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

    }

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