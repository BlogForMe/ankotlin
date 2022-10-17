/**
 * ClassName:      ViewModel
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/26 10:59 AM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/26 10:59 AM
 * UpdateRemark:   Modify the description
 */
package com.john.kot.hilt.dn.di

import android.app.Activity
import android.app.Application
import android.util.Log

class HiltViewModel4(var user: User3, var application: Application, var activity: Activity) {
    var TAG = javaClass.simpleName
    fun test() {
        Log.i(TAG, "test:user $user")
        Log.i(TAG, "test: application $application")
        Log.i(TAG, "test: activity$activity")
    }
}