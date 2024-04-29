package com.kot.hilt.dn.di

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *
 * ClassName:      MainViewModel
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/10/18
 * UpdateUser:     zh
 * UpdateDate:     2022/10/18
 * UpdateRemark:   Modify the description
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    var user: InterfaceUser,
//    var application: Application,
//    @ActivityContext var activity: Context,
) : ViewModel() { //这个ViewModel是jetpack库里的。
    var TAG = javaClass.simpleName
    fun test() {
        Log.i(TAG, "test:user $user")
//        Log.i(TAG, "test: application $application")
//        Log.i(TAG, "test: activity $activity")
//        Log.i(TAG, "test: context $context")
        user.test()
    }
}