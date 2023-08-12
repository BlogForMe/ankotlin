/**
 * ClassName:      AppModule
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/8/29 11:46 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/8/29 11:46 PM
 * UpdateRemark:   Modify the description
 */
package com.kot.hilt.dn.di

import android.app.Activity
import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

//Module装载到ActivityComponent中
@InstallIn(ActivityComponent::class) //这里用SingletonComponent会报错,因为Application不能提供activity实例
@Module
class AppModule4 {

    @ActivityScoped //Singleton,因为Application不能提供activity实例
    @Provides
    fun provideViewModel(
        user: User3,
        application: Application,
        activity: Activity
    ): HiltViewModel4 {
        return HiltViewModel4(user, application, activity)
    }
}