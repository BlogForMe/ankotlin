package com.kot.coroutine.dongnao

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
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

class CoroutineTest24 {

    @Test
    fun `test coroutine scope builder`() = runBlocking {
        coroutineScope {
            val job1 = launch {
                delay(400)
                println("Job1 finished.")
            }
            val job2 = async {
                delay(200)
                println("Job2 finished.")
                "job2 result"
            }
        }
    }

    @Test
    fun `test coroutineScope scope builder`() = runBlocking {
        coroutineScope {
            val job1 = launch {
                delay(400)
                println("job1 finished.")
            }
            val job2 = launch {
                delay(200)
                println("job2 finished.")
                "job2 result"
                throw  IllegalArgumentException()
            }
        }
    }

    @Test
    fun `test supervisorScope scope builder`() = runBlocking {
        supervisorScope {
            val job1 = launch {
                delay(400)
                println("job1 finished.")
            }
            val job2 = launch {
                delay(200)
                println("job2 finished.")
                "job2 result"
                throw  IllegalArgumentException()
            }
        }
    }
}