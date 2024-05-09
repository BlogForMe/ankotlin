package com.kot.tool.shake.util;

/**
 * ClassName:      Callback
 * Description:    Description
 * Author:         zh
 * CreateDate:     02/02/2024 17:33
 * UpdateUser:     zh
 * UpdateRemark:   Modify the description
 */

import com.alibaba.fastjson.JSONObject;

public interface Callback {
    void onTrigger(JSONObject var1, int var2);
}
