/**
 * ClassName:      AppModule
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/8/29 11:46 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/8/29 11:46 PM
 * UpdateRemark:   Modify the description
 */
package com.john.kot.hilt.di

import com.john.kot.hilt.model.User2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

//Module装载到ApplicationComponent中
@InstallIn(ActivityComponent::class) //通过这种方式和组件关联
@Module
class AppModule2 {
    @ActivityScoped //ActivityComponent只能设置ActivityScoped作用域
    @Provides
    fun provideUser(): User2 {
        return User2()
    }

//    @Provides
//    fun provideViewModel(user: User2?, application: Application?, activity: Activity?): ViewModel1 {
//        return ViewModel1(user, application, activity)
//    }
}