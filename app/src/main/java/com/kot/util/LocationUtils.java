package com.kot.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.ActivityCompat;

/**
 *
 */
public class LocationUtils {
    private volatile static LocationUtils uniqueInstance;

    private LocationHelper mLocationHelper;

    private MyLocationListener myLocationListener;

    private final LocationManager mLocationManager;

    private final Context mContext;

    /**
     * 定位时间15分钟
     */
    public static final int LOCATION_TIME = 15 * 60 * 1000;
    /**
     * 定位范围
     */
    public static final int LOCATION_MINDISTANCE = 50;

    /**
     * 初始化 时传入Application 避免泄露
     *
     * @param context
     */
    private LocationUtils(Context context) {
        mContext = context;
        mLocationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
    }

    /**
     * 采用Double CheckLock(DCL)实现单例
     *
     * @param context
     * @return
     */
    public static LocationUtils getInstance(Context context) {
        if (uniqueInstance == null) {
            synchronized (LocationUtils.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new LocationUtils(context);
                }
            }
        }
        return uniqueInstance;
    }

    /**
     * 初始化位置信息
     *
     * @param locationHelper 传入位置回调接口
     */
    public void initLocation(LocationHelper locationHelper) {
        Location location = null;
        mLocationHelper = locationHelper;
        if (myLocationListener == null) {
            myLocationListener = new MyLocationListener();
        }
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext,
            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        /**
         * 如果当前情况下没有NETWORK_PROVIDER模式，在接口回掉中会没有信息所以不会缓存
         */
        if (mLocationManager.getProvider(LocationManager.NETWORK_PROVIDER) != null) {
            Log.i("LocationUtils", "--默认使用低耗电的网络获取模式");
            /**
             * 默认使用低耗电的网络获取模式
             */
            location = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                locationHelper.updateLastLocation(location);
            }
            mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, LOCATION_TIME,
                LOCATION_MINDISTANCE, myLocationListener);

        }
        //        else {
        //            location = mLocationManager.getLastKnownLocation(LocationHelper.GPS_PROVIDER);
        //            if (location != null) {
        //                locationHelper.updateLastLocation(location);
        //            }
        //            mLocationManager.requestLocationUpdates(LocationHelper.GPS_PROVIDER,
        //            LOCATION_TIME, LOCATION_MINDISTANCE, myLocationListener);
        //        }
    }

    private class MyLocationListener implements LocationListener {
        /**
         * 定位服务状态改变会触发词函数
         */
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.i("LocationUtils", "LocationUtils--定位服务状态改变");
            if (mLocationHelper != null) {
                mLocationHelper.updateStatus(provider, status, extras);
            }
        }

        /**
         * 定位功能开启时会触发该函数
         *
         * @param provider
         */
        @Override
        public void onProviderEnabled(String provider) {
            Log.i("LocationUtils", "LocationUtils--定位功能开启 方式" + provider);
        }

        /**
         * 定位功能关闭时会触发该函数
         *
         * @param provider
         */
        @Override
        public void onProviderDisabled(String provider) {
            Log.i("LocationUtils", "-- 定位功能关闭 方式" + provider);
        }

        /**
         * 当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
         */
        @Override
        public void onLocationChanged(Location location) {
            Log.i(" LocationUtils-", "更新用户信息");
            if (mLocationHelper != null) {
                mLocationHelper.updateLocation(location);
            }
        }
    }

    /**
     * 移除定位
     */
    public void removeLocationUpdatesListener() {
        // 需要检查权限,否则编译不过
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext,
            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (mLocationManager != null) {
            if (myLocationListener != null) {
                mLocationManager.removeUpdates(myLocationListener);
            }
        }
    }
}
