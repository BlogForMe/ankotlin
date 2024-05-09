package com.john.kot.coroutine

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Test

/**
 *
 * ClassName:      Coroutines01
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/6/18 9:49 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/6/18 9:49 PM
 * UpdateRemark:   Modify the description
 */

class Coroutines01 {

    @Test
    fun testFeature() {
        println("hello")
        println("testFeature" + Thread.currentThread().name)

        val runBlocking = runBlocking {
            println("runBlocking " + Thread.currentThread().name)
            delay(2000)
            1
        }
        println("word $runBlocking")
    }





}