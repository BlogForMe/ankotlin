package com.john.kot.coroutine.dongnao

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

class CoroutineTest43 {

    @Test
    fun `test CoroutineContext `() = runBlocking<Unit> {
        val job = GlobalScope.launch {
            try {
                throw IndexOutOfBoundsException()
            } catch (e: Exception) {
                println("Caught IndexOutOfBoundsException")
            }
        }
        job.join()
        val deferred = GlobalScope.async {
            throw ArithmeticException()
        }
//        try {
//            deferred.await()
//        } catch (e: Exception) {
//            println("Caught ArithmeticException")
//        }
        delay(1000)
    }
}