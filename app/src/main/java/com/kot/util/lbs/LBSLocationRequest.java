package com.kot.util.lbs;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:      LBSLocationRequest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/7/6 10:06 AM
 * UpdateUser:     zh
 * UpdateDate:     2022/7/6 10:06 AM
 * UpdateRemark:   Modify the description
 */
public class LBSLocationRequest {
    private static long a;
    private static long b;
    private static long c;
    private static float d;
    public String bizType = "";
    public long cacheValidTime;
    public boolean isHighAccuracy;
    public long timeOut;
    public long updateInterval;
    public float minDistance;

    public LBSLocationRequest() {
        this.cacheValidTime = a;
        this.isHighAccuracy = false;
        this.timeOut = b;
        this.updateInterval = c;
        this.minDistance = d;
    }

    static {
        a = TimeUnit.SECONDS.toMillis(30L);
        b = TimeUnit.SECONDS.toMillis(60L);
        c = TimeUnit.SECONDS.toMillis(1L);
        d = 5.0F;
    }
}
