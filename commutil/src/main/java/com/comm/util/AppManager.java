//package com.comm.util;
//
//import android.app.Activity;
//import android.app.ActivityManager;
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//
//import java.util.List;
//import java.util.Stack;
//
//import timber.log.Timber;
//
//import static android.content.Context.ACTIVITY_SERVICE;
//
//public class AppManager {
//    private static Stack<Activity> activityStack;   // Activity栈  ， 先进后出
//    private static AppManager instance;
//
//    public static AppManager getAppManager() {
//        if (instance == null) {
//            instance = new AppManager();
//        }
//        return instance;
//    }
//
//    public void addActivity(Activity activity) {
//        if (activityStack == null) {
//            activityStack = new Stack<>();
//        }
//        activityStack.add(activity);
//    }
//
//    public void remove(Activity activity) {
//        if (activity != null) {
//            activityStack.remove(activity);
//            activity.finish();
//            activity = null;
//        }
//    }
//
////    public void  finishAllActiviy(){
////        for (Activity activity:activityStack){
////            activity.finish();
////            Timber.i( "finishAllActiviy     "+  activity.getLocalClassName());
////        }
////        activityStack.clear();
////    }
//
//    public boolean isActivityRun(Context context) {
//        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(100);
//        boolean isAppRunning = false;
//        String MY_PKG_NAME = context.getPackageName();
//        for (ActivityManager.RunningTaskInfo info : list) {
//            if (info.topActivity.getPackageName().equals(MY_PKG_NAME) || info.baseActivity.getPackageName().equals(MY_PKG_NAME)) {
//                isAppRunning = true;
////                Log.i(TAG,info.topActivity.getPackageName() + " info.baseActivity.getPackageName()="+info.baseActivity.getPackageName());
//                break;
//            }
//        }
//        return  isAppRunning;
//    }
//
////    private boolean isTopActivity(Activity activity) {
////        ActivityManager am = (ActivityManager) activity.getSystemService(ACTIVITY_SERVICE);
////        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
////        return cn.getClassName().contains(activity);
////    }
//
//
//
//}
