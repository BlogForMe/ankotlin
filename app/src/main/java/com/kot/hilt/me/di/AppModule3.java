/**
 * ClassName:      AppModule
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/8/29 11:46 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/8/29 11:46 PM
 * UpdateRemark:   Modify the description
 */
package com.kot.hilt.me.di;

//Module装载到ApplicationComponent中
//@InstallIn(ActivityComponent.class) //通过这种方式和组件关联
//@Module
//public class AppModule3 {
//
//    @ActivityScoped //ActivityComponent只能设置ActivityScoped作用域
//    @Provides
//    User3 provideUser() {
//        return new User3();
//    }
//
//    @Provides
//    ViewModel3 provideViewModel(User3 user, Application application, Activity activity,
//    @ApplicationContext Context context) {  //@ActivityContext换成@ApplicationContext
//        return new ViewModel3(user, application, activity,context);
//    }
//}
