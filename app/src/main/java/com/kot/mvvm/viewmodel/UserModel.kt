package com.kot.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.LinkedList

class UserModel : ViewModel() {
    private val _userLiveData = MutableLiveData<List<UserObject>>()
    val userLiveData: LiveData<List<UserObject>> = _userLiveData

    private val userList = LinkedList<UserObject>()

    fun doAction() {
        userList.add(UserObject("lili"))
        _userLiveData.postValue(userList)
    }
}