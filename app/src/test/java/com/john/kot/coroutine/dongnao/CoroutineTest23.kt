package com.john.kot.coroutine.dongnao

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 *
 * ClassName:      CoroutineTest23
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/7/27 9:37 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/7/27 9:37 PM
 * UpdateRemark:   Modify the description
 */

class CoroutineTest23 {

    @Test
    fun `test start mode`() = runBlocking {
        val job = launch(start = CoroutineStart.DEFAULT) {
            delay(1000)
            println("Job finished.")
        }
        delay(1000)
        job.cancel()
    }
}