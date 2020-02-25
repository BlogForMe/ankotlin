package com.comm.util;

import java.util.Calendar;

import static com.comm.util.SharedPrefsUtils.CONFIG_PARAM;
import static com.comm.util.SharedPrefsUtils.CONFIG_USER;
import static com.comm.util.SharedPrefsUtils.FILE_VIDEO;
import static com.comm.util.SharedPrefsUtils.INFORMATION_DISABLE;
import static com.comm.util.SharedPrefsUtils.KEY_ACTIVEMQ_HOST;
import static com.comm.util.SharedPrefsUtils.KEY_ACTIVEMQ_PORT;
import static com.comm.util.SharedPrefsUtils.KEY_ACTIVEMQ_PWD;
import static com.comm.util.SharedPrefsUtils.KEY_ACTIVEMQ_USERNAME;
import static com.comm.util.SharedPrefsUtils.KEY_AUDIO_MUTE_BEGIN;
import static com.comm.util.SharedPrefsUtils.KEY_AUDIO_MUTE_END;
import static com.comm.util.SharedPrefsUtils.KEY_BOX_BLUETOOTH;
import static com.comm.util.SharedPrefsUtils.KEY_BUGLYAPPId;
import static com.comm.util.SharedPrefsUtils.KEY_BoxFeature;
import static com.comm.util.SharedPrefsUtils.KEY_CAN_INPUT;
import static com.comm.util.SharedPrefsUtils.KEY_IsNeedCardId;
import static com.comm.util.SharedPrefsUtils.KEY_VIDEO;
import static com.comm.util.SharedPrefsUtils.PARAM_CUSTOM_PHONE;

/**
 * Created by Administrator on 11/23/2017.
 */

public class DeviceUtil {


    public static boolean getBoxFeature() {
        SharedPrefsUtils prefsUtils = new SharedPrefsUtils(CONFIG_USER);
        int boxType = prefsUtils.getInteger(KEY_BoxFeature, -1);
        if (boxType == 1) {
            return true;
        }
        return false;
    }

//    public static boolean isNeedCard() {
//        SharedPrefsUtils prefsUtils = new SharedPrefsUtils(CONFIG_USER);
//        return prefsUtils.getBoolean(KEY_IsNeedCardId);
//    }
//
//    public static String getBuglyId() {
//        return new SharedPrefsUtils(CONFIG_USER).getString(KEY_BUGLYAPPId, "");
//    }
//
//    public static String getACTIVEMQ_HOST() {
//        return new SharedPrefsUtils(, CONFIG_USER).getString(KEY_ACTIVEMQ_HOST, "");
//    }
//
//    public static int getACTIVEMQ_PORT() {
//        return new SharedPrefsUtils((), CONFIG_USER).getInteger(KEY_ACTIVEMQ_PORT, 1883);
//    }
//
//    public static String getACTIVEMQ_USERNAME() {
//        return new SharedPrefsUtils((), CONFIG_USER).getString(KEY_ACTIVEMQ_USERNAME, "admin");
//    }
//
//    public static String getACTIVEMQ_PWD() {
//        return new SharedPrefsUtils((), CONFIG_USER).getString(KEY_ACTIVEMQ_PWD, "admin");
//    }
//
//    public static boolean isKEY_CAN_INPUT() {
//        SharedPrefsUtils prefsUtils = new SharedPrefsUtils((), CONFIG_USER);
//        return prefsUtils.getBoolean(KEY_CAN_INPUT,true);
//    }

    public static boolean isVideo() {
        SharedPrefsUtils spUtil = new SharedPrefsUtils(FILE_VIDEO);
        return spUtil.getBoolean(KEY_VIDEO);
    }

    public static boolean isBoxBlueTooth() {
        SharedPrefsUtils prefsUtils = new SharedPrefsUtils(CONFIG_USER);
        return prefsUtils.getBoolean(KEY_BOX_BLUETOOTH);
    }

    public static boolean isInformationDisable() {
        SharedPrefsUtils prefsUtils = new SharedPrefsUtils(CONFIG_USER);
        return prefsUtils.getBoolean(INFORMATION_DISABLE);
    }

    public static boolean isPlayTime() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        SharedPrefsUtils prefsUtils = new SharedPrefsUtils(CONFIG_USER);
        int startTime = prefsUtils.getInteger(KEY_AUDIO_MUTE_BEGIN, 11);
        int endTime = prefsUtils.getInteger(KEY_AUDIO_MUTE_END, 6);
        if (hour >= startTime || hour < endTime) {
            return false;
        }
        return true;
    }


    public static String getParamPhone() {
        SharedPrefsUtils sp = new SharedPrefsUtils(CONFIG_PARAM);
        String phoneNum = sp.getString(PARAM_CUSTOM_PHONE, "");
        return formatPhone(phoneNum);
    }

    public static String formatPhone(String phoneNum) {
        if (phoneNum != null && phoneNum.length() == 11) {
            return phoneNum.substring(0, 3) + " " + phoneNum.substring(3, 7) + " " + phoneNum.substring(7, 11);
        }
        return phoneNum;
    }

}
