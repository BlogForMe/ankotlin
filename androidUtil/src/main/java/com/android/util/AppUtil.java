package com.android.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.core.content.FileProvider;


import java.io.File;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

import timber.log.Timber;

import static android.os.Process.killProcess;

/**
 * Created by A on 2018/3/15.
 */

public class AppUtil {
    private static Application myApp;
    static WeakReference<Activity> sTopActivityWeakRef;
    public static List<Activity> sActivityList = new LinkedList<>();


    public AppUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Application.ActivityLifecycleCallbacks mCallbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            sActivityList.add(activity);
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            sActivityList.remove(activity);
        }
    };

    public static void init(Application app) {
        AppUtil.myApp = app;
        ToastUtil.register(app);
//        if (isDebug()) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
//            ARouter.openLog();     // Print log
//            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
//        }
//        ARouter.init(app); // As early as possible, it is recommended to initialize in the Application

        app.registerActivityLifecycleCallbacks(mCallbacks);
        if (isDebug()) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    /**
     * 获取Application
     */
    public static Application getApp() {
        if (myApp != null) return myApp;
        throw new NullPointerException("u should init ");
    }

    private static void setTopActivityWeakRef(Activity activity) {
        if (sTopActivityWeakRef == null || !activity.equals(sTopActivityWeakRef.get())) {
            sTopActivityWeakRef = new WeakReference<>(activity);
        }
    }

    public static boolean getIsClassRomm() {
        for (Activity activity : sActivityList) {
            if ("ClassRoomActivity".equals(activity.getClass().getSimpleName())) {
                return true;
            }
        }
        return false;
    }
    public static boolean getIsClassRomm(String checkClass) {
        for (Activity activity : sActivityList) {
            if (checkClass.equals(activity.getClass().getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 当前版本Code
     *
     * @param context
     * @return
     */
    public static int getVerCode(Context context) {
        int verCode = -1;
        try {
            String packageName = context.getPackageName();
            verCode = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verCode;
    }

    /**
     * 得到软件显示版本信息
     *
     * @param context
     * @return
     */
    public static String getVerName(Context context) {
        String verName = "";
        String packageName = context.getPackageName();
        try {
            verName = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }


    /**
     * 启动到应用商店app详情界面
     *
     * @param appPkg    目标App的包名
     * @param marketPkg 应用商店包名 ,如果为""则由系统弹出应用商店列表供用户选择,否则调转到目标市场的应用详情界面，某些应用商店可能会失败
     */
    public static void launchAppDetail(Context context, String appPkg, String marketPkg) {
        try {
            if (TextUtils.isEmpty(appPkg)) return;

            Uri uri = Uri.parse("market://details?id=" + appPkg);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(marketPkg)) {
                intent.setPackage(marketPkg);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 安装
     * 7.0 以上记得配置 fileProvider
     */
    public static void installApk(Context context, File apkFile) {
        try {
            String authority = myApp.getPackageName() + ".fileProvider";
            Uri fileUri = FileProvider.getUriForFile(context, authority, apkFile);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            //7.0以上需要添加临时读取权限
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
            } else {
                Uri uri = Uri.fromFile(apkFile);
                intent.setDataAndType(uri, "application/vnd.android.package-archive");
            }
            context.startActivity(intent);

            //弹出安装窗口把原程序关闭。
            //避免安装完毕点击打开时没反应
            killProcess(android.os.Process.myPid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Token过期
     *
     * @param statusCode
     */
    public static void isTokenExpire(String statusCode) {
        if (myApp == null) {
            Timber.i("myApp  null");
            return;
        }
//        Intent intent = new Intent(myApp.getApplicationContext(), LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        myApp.startActivity(intent);
    }
}
