/**
 * ClassName:      AppModule
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/8/29 11:46 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/8/29 11:46 PM
 * UpdateRemark:   Modify the description
 */
package com.john.kot.hilt;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;

//Module装载到ApplicationComponent中
@InstallIn(ActivityComponent.class) //通过这种方式和组件关联
@Module
public class AppModule2 {

    @ActivityScoped //ActivityComponent只能设置ActivityScoped作用域
    @Provides
    User2 provideUser() {
        return new User2();
    }

    @Provides
    ViewModel1 provideViewModel(User2 user, Application application, Activity activity) {
        return new ViewModel1(user, application, activity);
    }
}