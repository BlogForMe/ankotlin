package com.comm.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by A on 2018/2/7.
 * https://github.com/DreaminginCodeZH/AndroidUtil
 * <p>
 */

public class SharedPrefsUtils {

    //扫描对象
    public static final String CONFIG_USER = "config_user";

    public static final String KEY_GET_ROOTER= "KEY_BoxRouter";
    public static final String KEY_BUGLYAPPId = "buglyAPPId";
    public static final String KEY_HOST = "host";
    public static final String KEY_IsNeedCardId = "isNeedCardId";
    public static final String KEY_BoxFeature = "boxFeature"; //箱子类型
    public static final String KEY_DISTRICT = "district";
    public static final String KEY_ACTIVEMQ_HOST = "activemq.host";
    public static final String KEY_ACTIVEMQ_PORT = "activemq.port";
    public static final String KEY_ACTIVEMQ_USERNAME = "activemq.username";
    public static final String KEY_ACTIVEMQ_PWD = "activemq.password";
    public static final String KEY_BOX_BLUETOOTH = "box.bluetooth";
    public static final String KEY_SEAL_IMAGEURL = "seal.imageUrl";
    public static final String KEY_SEAL_ENABLE = "seal.enable";
    public static final String KEY_CAN_INPUT = "box.canInput";
    public static final String KEY_RECIPE_TITLE = "recipe.title";
    public static final String KEY_RECIPE_TIPS = "recipe.tips";

    public static final String FILE_VIDEO = "FILE_VIDEO";
    public static final String KEY_VIDEO = "KEY_VIDEO";
    public static final String KEY_AUDIO_MUTE_BEGIN = "audio.mute.begin"; //播放时间
    public static final String KEY_AUDIO_MUTE_END = "audio.mute.end";
    public static final String INFORMATION_URL = "information.url";
    public static final String SPEANK_ADDR_SOUTHERN_FUJIAN_DIALECT = "speaker.addr.southernFujianDialect"; //闽南语url
    public static final String ORDER_ENABLE = "order.enable";               //#产品订购功能开关
    public static final String INFORMATION_DISABLE = "information.disable"; //资讯禁用
    public static final String MEASUURE_DISABLE_BLOODPRESSURE = "measure.disable.bloodPressure";
    public static final String MEASUURE_DISABLE_BLOODPGLUCOSE = "measure.disable.bloodGlucose";
    public static final String MEASUURE_DISABLE_BLOODOXYGEN = "measure.disable.bloodOxygen";
    public static final String MEASUURE_DISABLE_TEMPERATURE = "measure.disable.temperature";
    public static final String MEASUURE_DISABLE_URIC = "measure.disable.uric";
    public static final String MEASUURE_DISABLE_TC = "measure.disable.tc";
    public static final String MEASUURE_DISABLE_ECG = "measure.disable.ecg";
    public static final String MEASUURE_DISABLE_URINE = "measure.disable.urine"; //尿常规
    public static final String MEASUURE_DISABLE_12ECG = "measure.disable.12ecg";
    public static final String MEASUURE_DISABLE_REGISTRY = "registry.self.disable"; //自助注册


    public static final String CONFIG_PARAM = "config_param"; //文件
    public static final String PARAM_CUSTOM_PHONE = "config_param";
    public static final String PARAM_CHECK_ITEM = "PARAM_CHECK_ITEM";
    public static final String PARAM_WARD_SWITCH= "PARAM_WARD_SWITCH";



    public static final String PATIENTS_JSON = "PATIENTS_JSON";


    public static String CONSTANT_URL = "/csn_hospital_APIServer/RestService/Call/";
    public static String BURL = "health";
    public static String DEFAULT_URL = "https://" + BURL + ".casanubeserver.com";


    public static final String SP_FILE_CURRENT_PATIENT= "SP_FILE_CURRENT_PATIENT";
    public static final String CURRENT_BIND_USER_TYPE= "CURRENT_BIND_USER_TYPE";
    public static final String CURRENT_PATIENT_ID= "CURRENT_PATIENT_ID";



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
