package com.kot.tool.shake.sensor;

import com.alibaba.fastjson.JSONObject;

import android.content.Context;
import com.kot.tool.shake.util.Callback;
import com.kot.tool.shake.util.LifeCycle;

/**
 * ClassName:      SensorService
 * Description:    Description
 * Author:         zh
 * CreateDate:     02/02/2024 17:23
 * UpdateUser:     zh
 * UpdateRemark:   Modify the description
 */
public abstract class SensorService implements LifeCycle {
    public SensorService() {
    }

    public void create(Context context, JSONObject params) {
        this.onCreate(context, params);
    }

    public abstract void register(Callback var1);

    public abstract void unregister();

    public void destroy() {
        this.unregister();
        this.onDestroy();
    }
}
