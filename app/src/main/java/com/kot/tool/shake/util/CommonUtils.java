package com.kot.tool.shake.util;

import java.lang.reflect.Method;

import com.alibaba.fastjson.JSONObject;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.content.ContextCompat;

/**
 * ClassName:      CommonUtils
 * Description:    Description
 * Author:         zh
 * CreateDate:     02/02/2024 17:34
 * UpdateUser:     zh
 * UpdateRemark:   Modify the description
 */

public class CommonUtils {
    private static float sScale;
    private static LruCache<String, Uri> sCachedUriMap = new LruCache(20);

    public CommonUtils() {
    }

    public static long getLong(JSONObject params, String key) {
        return getLong(params, key, 0L);
    }

    public static long getLong(JSONObject params, String key, long df) {
        return (Long)getValue((JSONObject)params, key, df);
    }

    public static long getLong(Bundle bundle, String key) {
        return getLong(bundle, key, 0L);
    }

    public static long getLong(Bundle bundle, String key, long df) {
        return (Long)getValue((Bundle)bundle, key, df);
    }

    public static <T> T getValue(Bundle bundle, String key, T df) {
        try {
            if (bundle != null && !TextUtils.isEmpty(key)) {
                if (df == null) {
                    return df;
                } else if (!bundle.containsKey(key)) {
                    return df;
                } else {
                    T value = df;
                    Object obj = bundle.get(key);
                    if (obj != null && df.getClass().isAssignableFrom(obj.getClass())) {
                        value = (T)obj;
                    }

                    return value;
                }
            } else {
                return df;
            }
        } catch (Exception var5) {
            return df;
        }
    }

    public static <T> T getValue(JSONObject params, String key, T df) {
        if (params != null && !params.isEmpty()) {
            if (df == null) {
                return df;
            } else if (!params.containsKey(key)) {
                return df;
            } else {
                T value = df;
                Object obj = params.get(key);
                if (obj != null && df.getClass().isAssignableFrom(obj.getClass())) {
                    value = (T)obj;
                }

                return value;
            }
        } else {
            return df;
        }
    }

    public static int dip2px(Context context, float dpValue) {
        initScale(context);
        return (int)(dpValue * sScale + 0.5F);
    }

    private static void initScale(Context context) {
        try {
            if (sScale == 0.0F) {
                sScale = context.getResources().getDisplayMetrics().density;
            }
        } catch (Throwable var2) {
        }

    }

    public static boolean contains(JSONObject params, String key) {
        return params != null && !params.isEmpty() && params.containsKey(key);
    }

    public static float getFloat(JSONObject params, String key, float df) {
        return (Float)getValue((JSONObject)params, key, df);
    }

    public static int getInt(JSONObject params, String key) {
        return getInt(params, key, 0);
    }

    public static int getInt(JSONObject params, String key, int df) {
        return (Integer)getValue((JSONObject)params, key, df);
    }

    public static boolean isAppPermissionOPen(Context context) {
        try {
            if (context == null) {
                return false;
            }

            if (VERSION.SDK_INT < 23) {
                return isLessThanMarshmallowHasLocation(context);
            }

            int permissionCheck = ContextCompat.checkSelfPermission(context,
                "android.permission.ACCESS_COARSE_LOCATION");
            if (permissionCheck == 0) {
                return true;
            }
        } catch (Throwable var2) {
        }

        return false;
    }

    private static boolean isLessThanMarshmallowHasLocation(Context context) {
        return VERSION.SDK_INT >= 19 ? isPermissionGranted(context, 0) : true;
    }

    private static boolean isPermissionGranted(Context context, int permissionCode) {
        try {
            Object object = context.getSystemService("appops");
            if (object == null) {
                return false;
            } else {
                Class localClass = object.getClass();
                Class[] arrayOfClass = new Class[] {Integer.TYPE, Integer.TYPE, String.class};
                Method method = localClass.getMethod("checkOp", arrayOfClass);
                if (method == null) {
                    return false;
                } else {
                    Object[] arrayOfObject = new Object[] {permissionCode, Binder.getCallingUid(),
                        context.getPackageName()};
                    int m = (Integer)method.invoke(object, arrayOfObject);
                    return m == 0;
                }
            }
        } catch (Exception var8) {
            var8.printStackTrace();
            return false;
        }
    }

    public static String getString(JSONObject params, String key) {
        return getString(params, key, "");
    }

    public static String getString(JSONObject params, String key, String df) {
        if (df == null) {
            df = "";
        }

        return (String)getValue((JSONObject)params, key, df);
    }

    public static Uri parseUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        } else {
            Uri uri = (Uri)sCachedUriMap.get(url);
            if (uri != null) {
                return uri;
            } else {
                try {
                    uri = Uri.parse(url);
                    sCachedUriMap.put(url, uri);
                } catch (Exception var3) {
                }

                return uri;
            }
        }
    }
}