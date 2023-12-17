package com.android.util.hilt

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *
 * ClassName:      IModuleEntry
 * Description:    Description
 * Author:         zh
 * CreateDate:     12/17/23 09:45
 * UpdateUser:     zh
 * UpdateDate:     12/17/23 09:45
 * UpdateRemark:   Modify the description
 */

interface ISharedPreference {
    fun saveCache()
}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface SpEntryPoint {
    fun cache(): ISharedPreference
}

