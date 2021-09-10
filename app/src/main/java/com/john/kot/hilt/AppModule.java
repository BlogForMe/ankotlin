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

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

//Module装载到ApplicationComponent中
@InstallIn(ApplicationComponent.class) //通过这种方式和组件关联
@Module
public class AppModule {
    @Provides
    User provideUser(){
        return new User();
    }
}
