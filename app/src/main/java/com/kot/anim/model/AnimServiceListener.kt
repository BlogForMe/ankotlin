package com.kot.anim.model

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.john.kot.arch.recyclerview.CustomAdapter

/**
 *
 * ClassName:      AnimServiceListener
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/4/27 2:19 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/4/27 2:19 PM
 * UpdateRemark:   Modify the description
 */

class AnimServiceListener(val adapter: CustomAdapter) : DefaultLifecycleObserver {
    private val TAG = "AnimServiceListener"
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.i(TAG, "onCreate: ")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.i(TAG, "onStart: ")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.i(TAG, "onResume: ")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.i(TAG, "onPause: ")
//        adapter.findRelativeAdapterPositionIn(1,)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.i(TAG, "onStop: ")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.i(TAG, "onDestroy: ")
    }


}