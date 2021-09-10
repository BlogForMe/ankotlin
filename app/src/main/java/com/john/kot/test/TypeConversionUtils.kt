package com.john.kot.test

/**
 * author:wuyawen Administrator
 * create datatime：2018/10/12 on 17:21
 * des:
 *
 * @author Administrator
 */
object TypeConversionUtils {

    @JvmOverloads
    fun stringToDouble(str: String?, defaultValue: Double = 0.0): Double {
        return if (str.isNullOrBlank()) {
            defaultValue
        } else {
            try {
                str.toDouble()
            } catch (var4: Exception) {
                defaultValue
            }

        }
    }

    @JvmOverloads
    fun stringToLong(str: String?, defaultValue: Long = 0L): Long {
        return if (str.isNullOrBlank()) {
            defaultValue
        } else {
            try {
                str.toLong()
            } catch (var4: Exception) {
                defaultValue
            }
        }
    }

    @JvmOverloads
    fun stringToInt(str: String?, defaultValue: Int = 0): Int {
        return if (str.isNullOrBlank()) {
            defaultValue
        } else {
            try {
                str.toInt()
            } catch (e: Exception) {
                defaultValue
            }
        }
    }

    @JvmOverloads
    fun stringToFloat(str: String?, defaultValue: Float = 0.0f): Float {
        return if (str.isNullOrBlank()) {
            defaultValue
        } else {
            try {
                str.toFloat()
            } catch (e: Exception) {
                defaultValue
            }
        }
    }

    @JvmOverloads
    fun stringToBoolean(str: String?, ignoreCase: Boolean = false): Boolean {
        return str != null && str.equals("true", ignoreCase)
    }
}
