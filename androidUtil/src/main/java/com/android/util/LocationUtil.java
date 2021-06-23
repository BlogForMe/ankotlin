package com.android.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import java.util.List;

import timber.log.Timber;

/**
 * https://cloud.tencent.com/developer/article/1486427
 */
public class LocationUtil {
    private static LocationUtil ourInstance;

    private  LocationManager locationManager;
    private Context mContext;
    public static LocationUtil getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new LocationUtil(context);
        }
        return ourInstance;
    }


    private LocationUtil(Context context) {
        this.mContext = context;
    }

    public void getLastLocation() {
        // 获取位置服务
        String serviceName = Context.LOCATION_SERVICE;
// 调用getSystemService()方法来获取LocationManager对象
        locationManager = (LocationManager) mContext.getSystemService(serviceName);

        // 指定LocationManager的定位方法
        //获取当前可用的位置控制器
        List<String> list = locationManager.getProviders(true);
        String provider=null;
        if (list.contains(LocationManager.GPS_PROVIDER)){
             provider = LocationManager.GPS_PROVIDER;
        }else if (list.contains(LocationManager.NETWORK_PROVIDER)){
            provider = LocationManager.NETWORK_PROVIDER;
        }

// 调用getLastKnownLocation()方法获取当前的位置信息
        Location location = locationManager.getLastKnownLocation(provider);
        if (location!=null){
            //获取纬度
            double lat = location.getLatitude();
//获取经度
            double lng = location.getLongitude();

            Timber.i("lat  " +lat + " lng " +lng);
        }
    }


}
