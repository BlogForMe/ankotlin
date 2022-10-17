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

//Module装载到ApplicationComponent中
@InstallIn(ActivityComponent::class) //通过这种方式和组件关联
@Module
class AppModule1 {
    // ActivityComponent只能设置ActivityScoped作用域,
    // ApplicationComponent对应的作用域 @Singleton
//    @Singleton
    @Provides
    fun provideUser(): User1 {
        return User1()
    }
}