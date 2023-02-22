package com.android.util

import java.util.*
import java.util.regex.Pattern

//百捷
const val RESULT_LOW = "low"
const val RESULT_NORMAL = "normal"
const val RESULT_HIGH = "high"
const val RESULT_VERY_HIGH = "very_high"


//正则校验
fun String?.validation(pattern: String): Boolean {
    return if (this.isNullOrEmpty()) {
        false
    } else
        Pattern.compile(pattern).matcher(this).matches()
}


fun getRandomString(length: Int): String {
    val str =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    val random = Random()
    val sb = StringBuffer()
    for (i in 0 until length) {
        val number = random.nextInt(62)
        sb.append(str[number])
    }
    return sb.toString()
}


/**
 * 和两个数比较
 *
 * @param dataValue
 * @param array
 * @return
 */
fun twoDoubleRange(dataValue: Double, array: DoubleArray): String? {
    var conclusion = ""
    if (dataValue < array[0]) {
        conclusion = RESULT_LOW
    } else if (dataValue >= array[0] && dataValue < array[1]) {
        conclusion = RESULT_NORMAL
    } else if (dataValue > array[1]) {
        conclusion = RESULT_HIGH
    }
    return conclusion
}

fun getTwoIntRange(dataValue: Int, array: IntArray): String? {
    var conclusion = ""
    if (dataValue < array[0]) {
        conclusion = RESULT_LOW
    } else if (dataValue >= array[0] && dataValue < array[1]) {
        conclusion = RESULT_NORMAL
    } else if (dataValue > array[1]) {
        conclusion = RESULT_HIGH
    }
    return conclusion
}


/**
 * 三个数比较
 *
 * @param dataValue
 * @param array
 * @return
 */
fun getThreeRange(dataValue: Double, array: DoubleArray): String? {
    var conclusion = ""
    if (dataValue < array[0]) {
        conclusion = RESULT_LOW
    } else if (dataValue >= array[0] && dataValue < array[1]) {
        conclusion = RESULT_NORMAL
    } else if (dataValue > array[1] && dataValue < array[2]) {
        conclusion = RESULT_HIGH
    } else if (dataValue > array[2]) {
        conclusion = RESULT_VERY_HIGH
    }
    return conclusion
}


fun getCheckDateConclusion(mealStatus: String, dataValue: Double, timeInterval: Int): String? {
    var conclusion = ""
    if ("BLOOD_GLUCOSE_AM" == mealStatus || "SLEEP_AM" == mealStatus) {
        if (dataValue <= 3.9) {
            conclusion = "rel_low"
        } else if (dataValue <= 7.0 && dataValue > 3.9) {
            conclusion = "normal"
        } else if (dataValue > 7.0 && dataValue <= 8.4) {
            conclusion = "rel_high"
        } else if (dataValue > 8.4) {
            conclusion = "very_high"
        }
    } else {
        if (timeInterval == 1) {
            if (dataValue <= 3.9) {
                conclusion = "rel_low"
            } else if (dataValue <= 9.4 && dataValue > 3.9) {
                conclusion = "normal"
            } else if (dataValue > 9.4 && dataValue <= 11.1) {
                conclusion = "rel_high"
            } else if (dataValue > 11.1) {
                conclusion = "very_high"
            }
        } else if (timeInterval == 2) {
            if (dataValue <= 3.9) {
                conclusion = "rel_low"
            } else if (dataValue <= 7.8 && dataValue > 3.9) {
                conclusion = "normal"
            } else if (dataValue > 7.8 && dataValue <= 11.1) {
                conclusion = "rel_high"
            } else if (dataValue > 11.1) {
                conclusion = "very_high"
            }
        }
    }
    return conclusion
}

fun getRemoteTxt(rmStates: Int): String? {
    var txt = ""
    when (rmStates) {
        0 -> txt = "未开始"
        1 -> txt = "问卷准备"
        2 -> txt = "检查进行中"
        3 -> txt = "报告编辑"
        4 -> txt = "检查完毕"
        5 -> txt = "已取消"
    }
    return txt
}

fun <T> Array<T>.printArray() {
    for (i in this) {
        print(" $i ")
    }
    println()
}

fun <T> List<T>.printArray() {
    for (i in this) {
        println("$i")
    }
    println()
}

