package com.john.kot.mvvm.scrap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class BodyDataModel : ViewModel() {
    var activityTime = MutableLiveData<String>()   //全天运动时长
    val activityCosts = MutableLiveData<Int>()     //全天运动消耗
    val calmTime = MutableLiveData<String>()       //全天静坐时长
    val calmCosts = MutableLiveData<Int>()      //全天静坐消耗
    val steps = MutableLiveData<Int>()          //全天总步数
    val meters = MutableLiveData<Int>()         //全天里程（米）
    val costs = MutableLiveData<Int>()          //全天消耗卡路里
    var heatNow = MutableLiveData<String>()          //当前心率

//    var spData = SingleLiveEvent<String>()

    var sleepTime = MutableLiveData<String>() //睡眠时间
}