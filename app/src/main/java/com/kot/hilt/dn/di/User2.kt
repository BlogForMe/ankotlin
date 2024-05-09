package com.kot.hilt.dn.di

import android.util.Log
import dagger.hilt.android.scopes.ActivityRetainedScoped

/**
 *
 * ClassName:      User1
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/10/17
 * UpdateUser:     zh
 * UpdateDate:     2022/10/17
 * UpdateRemark:   Modify the description
 */

@ActivityRetainedScoped
class User2 : InterfaceUser {
    override fun test() {
        Log.i("User2", "test: ")
    }
}

interface InterfaceUser {
    fun test()
}