package com.kot.util;

import android.location.Location;
import android.os.Bundle;

/**
 * Description:
 * Data：2018/8/29-15:28
 * Author: @tools
 */
public interface LocationHelper {
    /**
     * 位置信息发生改变
     *
     * @param location 地理信息
     */
    void updateLocation(Location location);

    /**
     * 位置状态发生改变
     *
     * @param provider
     * @param status
     * @param extras
     */
    void updateStatus(String provider, int status, Bundle extras);

    /**
     * 更新最后定位信息
     *
     * @param location
     */
    void updateLastLocation(Location location);

}