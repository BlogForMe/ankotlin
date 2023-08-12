package com.kot.mvvm.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private val _navigateToDetails = MutableLiveData<Boolean>()

    val navigateToDetails: LiveData<Boolean>
        get() = _navigateToDetails


    val _isShow = MutableLiveData<Int>()
    var isShow: MutableLiveData<Int> = _isShow


    var isVisible = MutableLiveData<Boolean>()

    fun userClicksOnButton() {
        _navigateToDetails.value = true
    }
}