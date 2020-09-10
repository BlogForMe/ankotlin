package com.john.kot.mvvm.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MvvmViewModel : ViewModel() {
    val numData =  MutableLiveData<Int>()
}