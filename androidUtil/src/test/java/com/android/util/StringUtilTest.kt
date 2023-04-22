package com.android.util

import org.junit.Assert
import org.junit.Test


class StringUtilTest {
    //    const val REGEX_FULL_NAME = "(?=.*[A-Za-z]+.*)[A-Za-z@\\/`'’‘,\\.\\(\\)\\-]{4,100}$"
//    val OLD_REG_ANDROID = "^[A-Za-z @\\/\\-'`,().]{4,100}$"
//    val REGEX_PATTERN = "(?=.*[A-Za-z]+)[A-Za-z0-9 @ \\/`'’‘,\\.\\(\\)\\-]{4,100}$"
    val REGEX_REMARKS_INPUT = "^\\p{ASCII}+$"
//
//    val OLD_REGEX_IOS = "(?=.*\\D$)(?=.*[A-Za-z]+.*)[A-Za-z0-9@/`'’‘,——\\.\\(\\)\\-]+$"
////    val OLD_REG_ANDROID = "^[A-Za-z@\\/\\-'`,()]{4,100}$"
//    val OLD_REG_ANDROID = "^[A-Za-z@\\/\\-'`,().]{4,100}$"
//
////    val NEW_REGEX_FULL_NAME = "(?=.*[A-Za-z]+.*)[A-Za-z@\\/`'’‘,\\.\\(\\)\\-\\s]{4,100}$"
//    val NEW_REGEX_FULL_NAME = "(?=.*[A-Za-z]+.*)[A-Za-z @\\/`'’‘,\\.\\(\\)\\-]{4,100}$"
//
//    @Test
//    fun testNewAndroid() {
//        Assert.assertTrue(validation(NEW_REGEX_FULL_NAME, "FJ JF addd ff fff"))
//        Assert.assertTrue(validation(NEW_REGEX_FULL_NAME, "Test name bbv fff"))
//
////        Assert.assertTrue(validation(OLD_REG_ANDROID, "FJJF          addd"))
//    }
//
//    @Test
//    fun testcaonfig() {
//        Assert.assertTrue(validation(OLD_REGEX_IOS, "FJ JFaddd"))
////        Assert.assertTrue(validation(OLD_REGEX_IOS, "?#?#"))
//
//    }
//
//    @Test
//    fun testcaonfigAndroid() {
////        Assert.assertTrue(validation(OLD_REGEX_IOS, "FJJF addd"))
//        Assert.assertTrue(validation(OLD_REG_ANDROID, "FJJF    addd ffif"))
//        Assert.assertTrue(validation(OLD_REG_ANDROID, "Test name bbv"))
//
////        Assert.assertTrue(validation(OLD_REGEX_IOS, "?#?#"))
//    }
//
//
//
//    @Test
//    fun test_validation() {
//        Assert.assertTrue(validation(REGEX_PATTERN, "999  addd"))
//        Assert.assertTrue(validation(REGEX_PATTERN, "999  addd"))
//    }
//
//
//    @Test
//    fun test_fff() {
//        Assert.assertTrue(validation(REGEX_REMARKS_INPUT, PRINT_ASCII))
//    }

    val PRINT_ASCII = """
        !"#${'$'}%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}~
    """.trimIndent()


    @Test
    fun myTest() {
        for (i in 1..200) {
            print(i)
        }
    }

    @Test
    fun test() {
        println()
        for (i in 32..127) {
            print(i.toChar())
        }
        println("\n")

    }

    @Test
    fun mytest() {
        val commant = "‘"
        println("commant    " + commant.chars())
    }
}