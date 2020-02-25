package com.comm.util;

import android.util.Log;

/**
 *    log 打印
 * Created by cyh on 2017/11/16.
 */

public class Logger {

    private  static  String TAG ="casanube";
    private  static  String TAG_ERROR ="casanube_ERROR";
    public static final String TAGN = "MainActivity";

    public static void d(String msg){

        Log.d(TAG,"-----message-----"+msg);
    }

    public static void d(String tag ,String msg){
        Log.d(tag,"-----message-----"+msg);
    }
    public static void e(String msg){
        Log.e(TAG_ERROR,"-----error-----"+msg);
    }

    public static void load(String msg){
        Log.d(TAG,"-----load-----"+msg);
    }


    public static void CrashReport(String msg){
        Log.d(TAG,"-----CrashReport-----"+msg);
//        String mac = CommonUtil.getMac();
//        if (mac  == null){
//            mac="cyh:";
//        }
//        CrashReport.postCatchedException(new Throwable("请求患者"+ StringUtil.PATIENTCODE+"mac地址："+mac+"---"+msg));
    }


}
