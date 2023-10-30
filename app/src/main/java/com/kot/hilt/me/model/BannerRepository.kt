package com.kot.hilt.me.model

import android.util.Log
import com.kot.hilt.dn.di.User
import com.kot.hilt.model.User5
import com.kot.hilt.model.UserParam1
import javax.inject.Inject

/**
 *
 * ClassName:      BannerRepository
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/9/21
 * UpdateUser:     zh
 * UpdateDate:     2023/9/21
 * UpdateRemark:   Modify the description
 */

class BannerRepository @Inject constructor() : IBannerApi {
    override fun getBanner() {
        Log.i("BannerRepository", "getBanner: ")
    }
}