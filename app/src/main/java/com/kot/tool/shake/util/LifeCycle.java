package com.kot.tool.shake.util;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;

/**
 * ClassName:      LifeCycle
 * Description:    Description
 * Author:         zh
 * CreateDate:     02/02/2024 17:24
 * UpdateUser:     zh
 * UpdateRemark:   Modify the description
 */
public interface LifeCycle {
    void onCreate(Context var1, JSONObject var2);

    void onDestroy();
}
