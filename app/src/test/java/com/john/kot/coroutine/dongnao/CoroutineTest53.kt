package com.kot.coroutine.dongnao

import kotlinx.coroutines.*
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

class CoroutineTest53 {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun `test exception aggregation`() = runBlocking {
        val handler = CoroutineExceptionHandler { _, excetption ->
            println("Caught $excetption ${excetption.suppressed.contentToString()}")
        }

        val job = GlobalScope.launch(handler) {
            launch {
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    throw ArithmeticException() // 2
                }
            }
            launch {
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    throw ArithmeticException() // 2
                }
            }
            launch {
                delay(100)
                throw IndexOutOfBoundsException() // 3
            }
        }
        job.join()
    }


}