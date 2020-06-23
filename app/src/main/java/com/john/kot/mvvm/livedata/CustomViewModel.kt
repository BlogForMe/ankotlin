package com.john.kot.mvvm.livedata

import android.os.SystemClock

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel


class CustomViewModel : ViewModel() {
    var mLiveData: MutableLiveData<Int>? = null
    private var mPostedValue = 10
    val liveData: MutableLiveData<Int>
        get() {
            if (mLiveData == null) {
                mLiveData = MutableLiveData()
            }
            loadData()
            return mLiveData!!
        }

    private fun loadData() {
        object : Thread() {
            override fun run() {
                SystemClock.sleep(2000)
                mLiveData!!.postValue(mPostedValue)
                mPostedValue = mPostedValue * 2
            }
        }.start()
    }
}