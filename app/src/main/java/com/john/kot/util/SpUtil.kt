package com.john.kot.util

import android.content.Context
import com.android.util.AppUtil


object SpUtil {
    val SP by lazy {
        AppUtil.getApp().getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    //读 SP 存储项
    fun <T> getValue(name: String, default: T): T = with(SP) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default) ?: ""
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw java.lang.IllegalArgumentException()
        }
        res as T
    }

    //写 SP 存储项
    fun <T> putValue(name: String, value: T) = with(SP.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("This type can't be saved into Preferences")
        }.apply()
    }

}