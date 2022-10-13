package com.john.kot.mvvm.demo

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var userData: MutableLiveData<UserDemo> = MutableLiveData()

    init {
        userData.value = UserDemo("张三", 24, "杭州")

        // 延迟3秒后修改数据，UI自动更新
        Thread{
            SystemClock.sleep(3000)
            userData.value!!.name  = "李四"
            userData.postValue(userData.value)
        }.start()
    }

    override fun onCleared() {
        Log.i("UserViewModel","onCleared：ViewModel 即将销毁")
    }
}