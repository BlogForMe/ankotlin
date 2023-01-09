package com.android.util.window.util

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

object DensityUtil {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}


@get:JvmName("dp2px")
val Float.dp: Float
    get() = convert(this, TypedValue.COMPLEX_UNIT_DIP)

@get:JvmName("dp2px")
val Int.dp: Int
    get() = convert(this.toFloat(), TypedValue.COMPLEX_UNIT_DIP).toInt()


@get:JvmName("sp2px")
val Float.sp: Float
    get() = convert(this, TypedValue.COMPLEX_UNIT_SP)

@get:JvmName("sp2px")
val Int.sp: Int
    get() = convert(this.toFloat(), TypedValue.COMPLEX_UNIT_SP).toInt()

private fun convert(value: Float, type: Int): Float {
    val displayMetrics = Resources.getSystem().displayMetrics
    return TypedValue.applyDimension(type, value, displayMetrics)
}

/**
 * 获取屏幕高度
 */
fun getScreenHeight(): Int {
    val dm = Resources.getSystem().displayMetrics
    return dm.heightPixels
}

fun getScreenWidth(): Int {
    val dm = Resources.getSystem().displayMetrics
    return dm.widthPixels
}