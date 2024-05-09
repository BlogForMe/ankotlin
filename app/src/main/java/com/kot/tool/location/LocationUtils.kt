package com.kot.tool.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.core.app.ActivityCompat

class LocationUtils private constructor(private val mContext: Context) {
    //private LocationHelper mLocationHelper;
    var TAG = "LocationUtils"
    private var myLocationListener: MyLocationListener? = null
    private val mLocationManager: LocationManager?

    /**
     * 初始化 时传入Application 避免泄露
     *
     * @param context
     */
    init {
        mLocationManager = mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    /**
     * 初始化位置信息
     *
     */
    fun initLocation() {
        var location: Location? = null
        if (myLocationListener == null) {
            myLocationListener = MyLocationListener()
        }
        if (ActivityCompat.checkSelfPermission(
                mContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                mContext,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        /**
         * 如果当前情况下没有NETWORK_PROVIDER模式，在接口回掉中会没有信息所以不会缓存
         */
        if (mLocationManager?.getProvider(LocationManager.GPS_PROVIDER) != null) {
            //LogUtils.Companion.i("LocationUtils--默认使用低耗电的网络获取模式");
            /**
             * 默认使用低耗电的网络获取模式
             */
            location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (location != null) {
//                locationHelper.updateLastLocation(location);
                Log.i(
                    TAG,
                    " mLocationManager-- 更新用户信息" + location.latitude + " " + location.longitude + " isFromMockProvider " + location.isFromMockProvider
                )
            }
            mLocationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                LOCATION_TIME.toLong(),
                LOCATION_MINDISTANCE.toFloat(),
                myLocationListener!!
            )
        }
        //        else {
//            location = mLocationManager.getLastKnownLocation(LocationHelper.GPS_PROVIDER);
//            if (location != null) {
//                locationHelper.updateLastLocation(location);
//            }
//            mLocationManager.requestLocationUpdates(LocationHelper.GPS_PROVIDER, LOCATION_TIME, LOCATION_MINDISTANCE, myLocationListener);
//        }
    }

    private inner class MyLocationListener : LocationListener {
        /**
         * 定位服务状态改变会触发词函数
         */
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
            //LogUtils.Companion.i("LocationUtils--定位服务状态改变");
            //if (mLocationHelper != null) {
            //    mLocationHelper.updateStatus(provider, status, extras);
            //}
            Log.i(TAG, "onStatusChanged: ")
        }

        /**
         * 定位功能开启时会触发该函数
         *
         * @param provider
         */
        override fun onProviderEnabled(provider: String) {
            Log.i(TAG, "LocationUtils--定位功能开启 方式$provider")
        }

        /**
         * 定位功能关闭时会触发该函数
         *
         * @param provider
         */
        override fun onProviderDisabled(provider: String) {
            Log.i(TAG, "LocationUtils-- 定位功能关闭 方式$provider")
        }

        /**
         * 当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
         */
        override fun onLocationChanged(location: Location) {
            Log.i(
                TAG,
                " LocationUtils-- 更新用户信息" + location.latitude + " " + location.longitude + " isFromMockProvider " + location.isFromMockProvider
            )
            Log.i(
                TAG,
                " LocationUtils-- 更新用户信息" +isDetected()
            )

            //if (mLocationHelper != null) {
            //    mLocationHelper.updateLocation(location);
            //}
        }
    }

    /**
     * 移除定位
     */
    fun removeLocationUpdatesListener() {
        // 需要检查权限,否则编译不过
        if (ActivityCompat.checkSelfPermission(
                mContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                mContext,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        if (mLocationManager != null) {
            if (myLocationListener != null) {
                mLocationManager.removeUpdates(myLocationListener!!)
            }
        }
    }

    fun isDetected():Boolean{
        // returns true if mock location enabled, false if not enabled.
        if (Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.ALLOW_MOCK_LOCATION).equals("0"))
            return false;
        else return true;
    }

    companion object {
        @Volatile
        private var uniqueInstance: LocationUtils? = null

        /**
         * 定位时间15分钟
         */
        const val LOCATION_TIME = 15 * 1000

        /**
         * 定位范围
         */
        const val LOCATION_MINDISTANCE = 50

        /**
         * 采用Double CheckLock(DCL)实现单例
         *
         * @param context
         * @return
         */
        fun getInstance(context: Context): LocationUtils? {
            if (uniqueInstance == null) {
                synchronized(LocationUtils::class.java) {
                    if (uniqueInstance == null) {
                        uniqueInstance = LocationUtils(context)
                    }
                }
            }
            return uniqueInstance
        }
    }



}