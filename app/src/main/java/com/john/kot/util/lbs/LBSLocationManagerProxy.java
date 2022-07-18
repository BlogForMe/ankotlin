package com.john.kot.util.lbs;

import android.content.Context;

/**
 * ClassName:      LBSLocationManagerProxy
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/7/6 10:01 AM
 * UpdateUser:     zh
 * UpdateDate:     2022/7/6 10:01 AM
 * UpdateRemark:   Modify the description
 */
public class LBSLocationManagerProxy {
    private static LBSLocationManagerProxy a;
    private BProxy b;

    private LBSLocationManagerProxy() {
    }

    public static LBSLocationManagerProxy getInstance() {
        if (a == null) {
            Class var0 = LBSLocationManagerProxy.class;
            synchronized (LBSLocationManagerProxy.class) {
                if (a == null) {
                    a = new LBSLocationManagerProxy();
                    a.a();
                }
            }
        }

        return a;
    }

    private void a() {
        this.b = new BProxy();
    }

    public String getLastKnownLocation(Context context, LBSLocationRequest request) {
        //return this.b.a(context, request);
        String s = null;
        return s.toLowerCase();
    }
    //
    //public void refreshCache(Context context) {
    //    this.b.a(context);
    //}
    //
    //public void requestLocationUpdate(Context context, LBSLocationRequest request,
    // LBSLocationListener listener) {
    //    this.b.a(context, request, listener);
    //}
    //
    //public void requestLocationUpdateContinuous(Context context, LBSLocationRequest request,
    // LBSLocationListener listener) {
    //    this.b.b(context, request, listener);
    //}
    //
    //public void removeLocationUpdates(Context context, LBSLocationListener listener) {
    //    this.b.a(context, listener);
    //}
}
