package com.kot.util

import android.content.Context
import android.content.SharedPreferences
import com.android.util.AppUtil
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class DelegateSharedPreferencesUtils {
    object User : Delegates() {
        override fun getSharedPreferencesName(): String = this.javaClass.simpleName
        var name by string()
        var phone by long()
    }


    abstract class Delegates {
        private val preferences: SharedPreferences by lazy {
            AppUtil.getApp().applicationContext.getSharedPreferences(
                getSharedPreferencesName(),
                Context.MODE_PRIVATE
            )
        }

        abstract fun getSharedPreferencesName(): String


        fun int(defaultValue: Int = 0) = object : ReadWriteProperty<Any, Int> {
            override fun getValue(thisRef: Any, property: KProperty<*>): Int {
                return preferences.getInt(property.name, defaultValue)
            }

            override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
                preferences.edit().putInt(property.name, value).apply()
            }
        }

        fun string(defaultValue: String? = null) = object : ReadWriteProperty<Any, String?> {
            override fun getValue(thisRef: Any, property: KProperty<*>): String? {
                return preferences.getString(property.name, defaultValue)
            }

            override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) {
                preferences.edit().putString(property.name, value).apply()
            }
        }

        fun long(defaultValue: Long = 0L) = object : ReadWriteProperty<Any, Long> {

            override fun getValue(thisRef: Any, property: KProperty<*>): Long {
                return preferences.getLong(property.name, defaultValue)
            }

            override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) {
                preferences.edit().putLong(property.name, value).apply()
            }
        }

        fun boolean(defaultValue: Boolean = false) = object : ReadWriteProperty<Any, Boolean> {
            override fun getValue(thisRef: Any, property: KProperty<*>): Boolean {
                return preferences.getBoolean(property.name, defaultValue)
            }

            override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
                preferences.edit().putBoolean(property.name, value).apply()
            }
        }

        fun float(defaultValue: Float = 0.0f) = object : ReadWriteProperty<Any, Float> {
            override fun getValue(thisRef: Any, property: KProperty<*>): Float {
                return preferences.getFloat(property.name, defaultValue)
            }

            override fun setValue(thisRef: Any, property: KProperty<*>, value: Float) {
                preferences.edit().putFloat(property.name, value).apply()
            }
        }

        fun setString(defaultValue: Set<String>? = null) = object :
            ReadWriteProperty<DelegateSharedPreferencesUtils, Set<String>?> {
            override fun getValue(
                thisRef: DelegateSharedPreferencesUtils,
                property: KProperty<*>
            ): Set<String>? {
                return preferences.getStringSet(property.name, defaultValue)
            }

            override fun setValue(
                thisRef: DelegateSharedPreferencesUtils,
                property: KProperty<*>,
                value: Set<String>?
            ) {
                preferences.edit().putStringSet(property.name, value).apply()
            }
        }

        fun clearAll() {
            preferences.edit().clear().apply()
        }
    }
}

