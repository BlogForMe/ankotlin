/**
 * ClassName:      AppModule
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/8/29 11:46 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/8/29 11:46 PM
 * UpdateRemark:   Modify the description
 */
package com.john.kot.hilt.dn.di

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

//Module装载到ActivityComponent中
@InstallIn(ActivityComponent::class) //这里用SingletonComponent会报错,因为Application不能提供activity实例
@Module
class AppModule5 {

    @Provides
    fun provideViewModel(
        user: User3,
        application: Application,
        activity: Activity,
        @ApplicationContext context: Context
    ): HiltViewModel5 {
        return HiltViewModel5(user, application, activity, context)
    }
}