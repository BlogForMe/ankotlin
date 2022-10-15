package com.john.kot.hilt.di

import com.john.kot.hilt.model.UserHilt5
import com.john.kot.hilt.model.UserParam5
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 * ClassName:      AppModule5
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/10/15
 * UpdateUser:     zh
 * UpdateDate:     2022/10/15
 * UpdateRemark:   Modify the description
 */

@InstallIn(SingletonComponent::class) //通过这种方式和组件关联
@Module
class AppModule5 {

    @Singleton
    @Provides
    fun provideUser(): UserHilt5 {
        return UserHilt5()
    }

    @Singleton
    @Provides
    fun provideUserParam5(user: UserHilt5): UserParam5 {
        return UserParam5(user)
    }
}