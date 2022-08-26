package com.john.kot.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class UserModel : ViewModel() {
    private val userLiveData = MutableLiveData<List<User>>()
    private val userList = LinkedList<User>()
    val user: LiveData<List<User>>
        get() = userLiveData

    fun doAction() {
        userList.add(User("lili"))
        userLiveData.postValue(userList)
    }
}