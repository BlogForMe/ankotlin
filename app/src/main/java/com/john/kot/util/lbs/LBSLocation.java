package com.john.kot.util.lbs;

import android.location.Location;

/**
 * ClassName:      LBSLocation
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/7/6 10:05 AM
 * UpdateUser:     zh
 * UpdateDate:     2022/7/6 10:05 AM
 * UpdateRemark:   Modify the description
 */
public class LBSLocation extends Location {
    private long a = 0L;
    private int b;

    public LBSLocation(Location location) {
        super(location);
    }

    public LBSLocation() {
        super("");
    }

    public String getType() {
        return super.getProvider();
    }

    public void setType(String type) {
        super.setProvider(type);
    }

    public long getTimeCost() {
        return this.a;
    }

    public void setTimeCost(long timeCost) {
        this.a = timeCost;
    }

    public double getLatitude() {
        return super.getLatitude();
    }

    public void setLatitude(double latitude) {
        super.setLatitude(latitude);
    }

    public double getLongitude() {
        return super.getLongitude();
    }

    public void setLongitude(double longitude) {
        super.setLongitude(longitude);
    }

    public long getTime() {
        return super.getTime();
    }

    public void setTime(long time) {
        super.setTime(time);
    }

    public float getAccuracy() {
        return super.getAccuracy();
    }

    public void setAccuracy(float accuracy) {
        super.setAccuracy(accuracy);
    }

    public int getErrorCode() {
        return this.b;
    }

    public void setErrorCode(int errorCode) {
        this.b = errorCode;
    }
}
