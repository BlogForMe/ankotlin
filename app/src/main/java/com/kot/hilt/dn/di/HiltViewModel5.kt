/**
 * ClassName:      ViewModel
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/26 10:59 AM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/26 10:59 AM
 * UpdateRemark:   Modify the description
 */
package com.kot.hilt.dn.di

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import javax.inject.Inject

//默认装载到了ApplicationComponent中
class HiltViewModel5 @Inject constructor(
    var user: User3,
    var application: Application,
    var activity: Activity,
    var context: Context
) {
    var TAG = javaClass.simpleName
    fun test() {
        Log.i(TAG, "test:user $user")
        Log.i(TAG, "test: application $application")
        Log.i(TAG, "test: activity $activity")
        Log.i(TAG, "test: context $context")

    }
}