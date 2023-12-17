package com.kot.hilt

import android.util.Log
import com.android.util.hilt.ISharedPreference
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

/**
 *
 * ClassName:      SharedPreferenceImpl
 * Description:    Description
 * Author:         zh
 * CreateDate:     12/17/23 10:18
 * UpdateUser:     zh
 * UpdateDate:     12/17/23 10:18
 * UpdateRemark:   the class should be in another module that the project does not have
 */


class SharedPreferenceImpl @Inject constructor() : ISharedPreference {
    override fun saveCache() {
        Log.i(TAG, "saveCache: ")
    }
}

private val TAG = "SharedPreferenceImpl"

@Module
@InstallIn(SingletonComponent::class)
abstract class SpModule {
    @Binds
    abstract fun bindDone(imp: SharedPreferenceImpl): ISharedPreference

}