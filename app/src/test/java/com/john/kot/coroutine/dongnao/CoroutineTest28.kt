package com.kot.coroutine.dongnao

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 *
 * ClassName:      Coroutine26
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/7/28 9:17 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/7/28 9:17 PM
 * UpdateRemark:   Modify the description
 */

class CoroutineTest28 {

    @Test
    fun `test CancellationException `() = runBlocking<Unit> {
        val job1 = GlobalScope.launch {
            try {
                delay(1000)
                println("Job 1.")
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        delay(100)
        job1.cancel(CancellationException("取消"))
        job1.join() // 否则不会打印GlobalScope不在runBlocking上下文
    }
}