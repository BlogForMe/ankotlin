package com.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by A on 2018/2/7.
 * https://github.com/DreaminginCodeZH/AndroidUtil
 * <p>
 */

public class SharedPrefsUtils {


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

    public SharedPrefsUtils(Context context, String fileName) {
        if (!TextUtils.isEmpty(fileName)) {
            this.fileName = fileName;
        }
        mSharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public SharedPrefsUtils(String fileName) {
        this.fileName = fileName;
        if (!TextUtils.isEmpty(fileName)) {
            this.fileName = fileName;
        }
        mSharedPreferences = AppUtil.getApp().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void putString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.apply();
    }
    public void putLong(String key, long value) {
        mEditor.putLong(key, value);
        mEditor.commit();
    }
  public long getLong(String key,long defaultValue) {
      return mSharedPreferences.getLong(key,defaultValue);
    }

    public void putInteger(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public int getInteger(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public String getString(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean detrue) {
        return mSharedPreferences.getBoolean(key, detrue);
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


//    public void saveSpPatient(String pat) {
//        putString(KEY_PATIENT, pat);
//    }
//
//    public Patient getSpPatient() {
//        String paJson = getString(KEY_PATIENT, "");
//        Patient patient = CGsonUtil.gson.fromJson(paJson, Patient.class);
//        return patient;
//    }


}
