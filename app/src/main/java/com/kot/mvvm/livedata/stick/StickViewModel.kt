package com.kot.mvvm.livedata.stick

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *
 * ClassName:      MainViewModel
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/8/17 7:20 AM
 * UpdateUser:     zh
 * UpdateDate:     2022/8/17 7:20 AM
 * UpdateRemark:   Modify the description
 */

class StickViewModel : ViewModel() {
    //默认粘性效果
    val textLiveData = MutableLiveData<String>()
    //去除粘性效果
//    val text: CleanLiveData<String> by lazy {
//        CleanLiveData<String>()
//    }
}