package com.john.kot.mvvm.dongnao.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(val savedState: SavedStateHandle) : ViewModel() {
    val TAG = "MyViewModel"

    companion object {
        val NAME_KEY = "name"
    }

    var number = 0

    fun getName() {
        val get = savedState.get<String>(NAME_KEY)
        Log.i(TAG, "getName: $get")
    }


}