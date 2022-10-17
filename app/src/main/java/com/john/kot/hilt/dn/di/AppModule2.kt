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

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

//Module装载到ActivityComponent中
@InstallIn(ActivityComponent::class) //通过这种方式和组件关联
@Module
class AppModule2 {
    // ApplicationComponent对应的作用域 @Singleton
    @ActivityScoped
    @Provides
    fun provideUser(): User2 {
        return User2()
    }
}