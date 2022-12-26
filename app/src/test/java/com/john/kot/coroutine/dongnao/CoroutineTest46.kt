package com.john.kot.coroutine.dongnao

import kotlinx.coroutines.*
import org.junit.Test
import java.lang.IllegalArgumentException

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

class CoroutineTest46 {

    @Test
    fun `test SupervisorJob `() = runBlocking<Unit> {
        val supervisor = CoroutineScope(SupervisorJob())
        val job1 = supervisor.launch {
            delay(100)
            println("child 1")
            throw IllegalArgumentException()
        }
        val job2 = supervisor.launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                println("child 2 finished.")
            }
            throw IllegalArgumentException()
        }
        joinAll(job1, job2)
    }

}