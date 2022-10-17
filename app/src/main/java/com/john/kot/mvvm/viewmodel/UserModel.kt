package com.john.kot.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class UserModel : ViewModel() {
    private val userLiveData = MutableLiveData<List<UserObject>>()
    private val userList = LinkedList<UserObject>()
    val user: LiveData<List<UserObject>>
        get() = userLiveData

    fun doAction() {
        userList.add(UserObject("lili"))
        userLiveData.postValue(userList)
    }
}