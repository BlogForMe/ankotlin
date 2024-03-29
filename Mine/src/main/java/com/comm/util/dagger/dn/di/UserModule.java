/**
 * ClassName:      UserModule
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/25 4:41 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/25 4:41 PM
 * UpdateRemark:   Modify the description
 */
package com.comm.util.dagger.dn.di;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @UserScope
    @Provides
    User1 provideUser() {
        return new User1();
    }
}
