package com.android.util

import android.annotation.TargetApi
import android.content.Context
import android.view.WindowManager
import android.util.DisplayMetrics
import android.content.pm.PackageManager
import android.graphics.Point
import com.android.util.DisplayUtils
import android.net.wifi.WifiManager
import android.net.wifi.WifiInfo
import android.os.Build
import java.lang.Error
import java.lang.Exception
import java.lang.StringBuilder
import java.net.NetworkInterface
import java.util.*

/**
 * Created by A on 2018/2/23.
 * https://github.com/jingle1267/android-utils/blob/master/util/src/main/java/com/ihongqiqu/util/DisplayUtils.java
 */
object DisplayUtils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context
     * @param dpValue
     * @return
     */
    fun dp2px(context: Context?, dpValue: Float): Float {
        val scale = context!!.resources.displayMetrics.density
        return dpValue * scale + 0.5f
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    fun px2sp(context: Context, pxValue: Float): Float {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return pxValue / fontScale + 0.5f
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    fun sp2px(context: Context?, spValue: Float): Float {
        val fontScale = context!!.resources.displayMetrics.scaledDensity
        return spValue * fontScale + 0.5f
    }

    @TargetApi(13)
    fun getScreenSize(context: Context): Point {
        val windowManager = context.getSystemService("window") as WindowManager
        val display = windowManager.defaultDisplay
        return if (Build.VERSION.SDK_INT < 13) {
            Point(display.width, display.height)
        } else {
            val point = Point()
            display.getSize(point)
            point
        }
    }

    @JvmStatic
    fun getScreenW(context: Context): Float {
        val dm = context.resources.displayMetrics
        val w = dm.widthPixels
        return w.toFloat()
    }

    @JvmStatic
    fun getScreenH(context: Context): Float {
        val dm = context.resources.displayMetrics
        val h = dm.heightPixels
        return h.toFloat()
    }

    /**
     * 获取本地软件版本号
     */
    fun getLocalVersion(ctx: Context): Int {
        var localVersion = 0
        try {
            val packageInfo = ctx.applicationContext
                .packageManager
                .getPackageInfo(ctx.packageName, 0)
            localVersion = packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return localVersion
    }

    /**
     * 获取本地软件版本号名称
     */
    fun getLocalVersionName(ctx: Context): String {
        var localVersion = ""
        try {
            val packageInfo = ctx.applicationContext
                .packageManager
                .getPackageInfo(ctx.packageName, 0)
            localVersion = packageInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return localVersion
    }

    //根据Wifi信息获取本地Mac
    fun getMacAddr(context: Context): String {
        try {
            val all: List<NetworkInterface> =
                Collections.list(NetworkInterface.getNetworkInterfaces())
            for (nif in all) {
                if (!nif.name.equals("wlan0", ignoreCase = true)) continue
                val macBytes = nif.hardwareAddress ?: return ""
                val res1 = StringBuilder()
                for (b in macBytes) {
                    res1.append(String.format("%02X:", b))
                }
                if (res1.length > 0) {
                    res1.deleteCharAt(res1.length - 1)
                }
                return res1.toString()
            }
        } catch (ex: Exception) {
        }
        return getLocalMacAddressFromWifiInfo(context)
    }

    fun getLocalMacAddressFromWifiInfo(context: Context): String {
        val wifi = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val info = wifi.connectionInfo
        return if (info.macAddress != null && info.macAddress.length > 0) {
            info.macAddress
        } else ""
    }
}
