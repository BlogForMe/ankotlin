package com.android.util

import java.util.regex.Pattern

const val REGEX_CHINESE_WITH_INNER_SPACE = "^(?!\\s)(?!.*\\s\$)[\u4e00-\u9fa50-9a-zA-Z\\s]{2,15}"

// https://stackoverflow.com/questions/34974942/regex-for-no-whitespace-at-the-beginning-and-end

//正则校验
fun String?.validation(pattern: String): Boolean {
    return if (this.isNullOrEmpty()) {
        false
    } else
        Pattern.compile(pattern).matcher(this).matches()
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

