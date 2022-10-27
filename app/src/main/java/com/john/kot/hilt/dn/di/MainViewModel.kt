package com.john.kot.hilt.dn.di

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
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
    var user: User3,
    var application: Application,
//    var activity: Activity,
    @ApplicationContext var context: Context
) : ViewModel() { //这个ViewModel是jetpack库里的。
    var TAG = javaClass.simpleName
    fun test() {
        Log.i(TAG, "test:user $user")
//        Log.i(TAG, "test: application $application")
//        Log.i(TAG, "test: activity $activity")
        Log.i(TAG, "test: context $context")
    }
}