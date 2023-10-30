package com.kot.hilt.me.di

import com.kot.hilt.me.model.BannerRepository
import com.kot.hilt.me.model.IBannerApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 *
 * ClassName:      BannerRepoModule
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/9/21
 * UpdateUser:     zh
 * UpdateDate:     2023/9/21
 * UpdateRemark:   Modify the description
 */

@InstallIn(ActivityComponent::class)
@Module
abstract class BannerRepoModule {
    //BannerRepository实例自动new出来交给对应的接口
    @Binds
    abstract fun bannerRepo(repoImpl: BannerRepository): IBannerApi
}