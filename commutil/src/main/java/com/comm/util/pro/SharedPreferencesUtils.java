package com.comm.util.pro;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences的一个工具类，调用setParam就能保存String, Integer, Boolean, Float, Long类型的参数
 * 同样调用getParam就能获取到保存在手机里面的数据
 */
public class SharedPreferencesUtils {
    /**
     * 保存在手机里面的文件名
     */
    private static final String FILE_NAME = "share_foot";

    public static final String FILE_BOX = "FILE_BOX";

    public static final String DEVICE_BRAND = "device_brand";
    public static final String DOC_SESSION_ID = "doc_session_id";
    public static final String DOC_DOCTOR_ID = "doc_doctor_id";

    public static final String DOC_KEY_RONG_DOCTOR_NAME = "doc_rongyun_doctorName";


    //小红点控制
    public static final String DOC_REMOTE_CHECK = "DOC_REMOTE_CHECK";
    public static final String DOC_REMIND_REPORT = "DOC_REMIND_REPORT";
    public static final String DOC_REMIND_APPOINT = "DOC_REMIND_APPOINT";
    public static final String DOC_CHECK_REPLY = "DOC_CHECK_REPLY";


    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    public static void setParam(Context context, String key, Object object) {

        if (object == null) return;
        String type = object.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if ("String".equals(type)) {
            editor.putString(key, String.valueOf(object));
        } else if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) object);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) object);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) object);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) object);
        }

        editor.commit();
    }


    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object getParam(Context context, String key, Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        if ("String".equals(type)) {
            return sp.getString(key, String.valueOf(defaultObject));
        } else if ("Integer".equals(type)) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if ("Boolean".equals(type)) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if ("Float".equals(type)) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if ("Long".equals(type)) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }


    private final static String appConfigFile = "appConfigFile";
    public final static String keyConfig = "keyAppConfig";
//
//    public static AppConfig getAppConfig(String key) {
//        SharedPreferences sp = AppUtil.getApp().getSharedPreferences(appConfigFile, Context.MODE_PRIVATE);
//        String temp = sp.getString(key, "");
//        AppConfig bean = GsonUtil.gson.fromJson(temp, AppConfig.class);
//        return bean;
//    }
//
//
//    public static void saveAppConfig(String configTxt) {
//        SharedPreferences sp = AppUtil.getApp().getSharedPreferences(appConfigFile, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString(keyConfig, configTxt);
//        Boolean isCommt = editor.commit();
//        Timber.i("isCommt   " + isCommt);
//    }
//

    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }


}
