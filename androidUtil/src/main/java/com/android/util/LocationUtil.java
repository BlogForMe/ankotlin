package com.android.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import timber.log.Timber;

/**
 * https://cloud.tencent.com/developer/article/1486427
 */
public class LocationUtil {
    private static LocationUtil ourInstance;

    private final LocationManager locationManager;

    public static LocationUtil getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new LocationUtil(context);
        }
        return ourInstance;
    }

    private LocationUtil(Context context) {
        // 获取位置服务
        String serviceName = Context.LOCATION_SERVICE;
// 调用getSystemService()方法来获取LocationManager对象
        locationManager = (LocationManager) context.getSystemService(serviceName);
    }

    public void getLastLocation() {
        // 指定LocationManager的定位方法
        String provider = LocationManager.GPS_PROVIDER;
// 调用getLastKnownLocation()方法获取当前的位置信息
        Location location = locationManager.getLastKnownLocation(provider);

        //获取纬度
        double lat = location.getLatitude();
//获取经度
        double lng = location.getLongitude();

        Timber.i("lat  " +lat + " lng " +lng);
    }


}
