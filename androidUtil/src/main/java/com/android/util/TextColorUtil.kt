package com.android.util

import android.text.TextUtils.isEmpty

object  TextColorUtil {
    /**
     * 字体设置
     *
     * @param color
     * @param unit
     * @return
     */
    fun getUnitText(color: String, unit: String): String {
        return "<font color=$color><small><small><small>$unit</small></small></small></font>"
    }

    /**
     * 字体大小相同
     *
     * @param color
     * @param txt
     * @return
     */
    fun txtEqualTwo(color: String, txt: String): String {
        return "<font color=$color>$txt</font>"
    }

    fun getIsTxt(txt: String): String {
        return if (isEmpty(txt)) "" else txt
    }
}
