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

////Module装载到ApplicationComponent中
//@InstallIn(ApplicationComponent.class) //通过这种方式和组件关联
//@Module
//public class AppModule {
//      //ApplicationComponent对应的作用域 @Singleton
//    @Provides
//    User1 provideUser() {
//        return new User1();
//    }
//}