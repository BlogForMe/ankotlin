package com.comm.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by A on 2018/2/7.
 * https://github.com/DreaminginCodeZH/AndroidUtil
 * <p>
 */

public class CommonSPUtils<T> {

    //扫描对象

    public static final String DOC_FILE_LOGIN = "file_login_bean";
    public static final String DOC_KEY_RONG_TOKEN = "doc_rongyun_token";
    public static final String DOC_KEY_RONG_UNIONUSERID = "doc_rongyun_unionUserId";
//    public static final String DOC_KEY_RONG_DOCTOR_NAME = "doc_rongyun_doctorName";

    /**
     * 默认文件名
     */
    private String fileName;

    /**
     * SharedPreferences对象
     */
    private SharedPreferences mSharedPreferences = null;


    /**
     * Editor
     */
    private SharedPreferences.Editor mEditor = null;

    public CommonSPUtils(String fileName) {
        if (!TextUtils.isEmpty(fileName)) {
            this.fileName = fileName;
        }
        mSharedPreferences = AppUtil.getApp().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void putString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public String getString(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }


    /**
     * 删除某个值
     *
     * @param key
     */
    public void remove(String key) {
        mEditor.remove(key);
        mEditor.commit();
    }

    public void clear() {
        mEditor.clear().commit();
    }


    /**
     * 存储对象
     *
     * @param key
     * @param bean
     */
//    public void saveBean(String key, T bean) {
//        String temp = GsonUtil.gson.toJson(bean);
//        mEditor.putString(key, temp);
//        mEditor.commit();
//    }

    /**
     * 存入数据
     *
     * @param key
     * @param value 数据
     */
    public void put(String key, T value) {
        if (value instanceof String) {
            mEditor.putString(key, String.valueOf(value));
            mEditor.commit();
        }
    }

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public T get(String key) {
        try {
            return (T) mSharedPreferences.getString(key, "");
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

}
