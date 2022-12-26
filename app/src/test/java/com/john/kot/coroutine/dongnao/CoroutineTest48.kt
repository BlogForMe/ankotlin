package com.john.kot.coroutine.dongnao

import kotlinx.coroutines.*
import org.junit.Test
import java.lang.AssertionError
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

class CoroutineTest48 {

    @Test
    fun `test SupervisorJob `() = runBlocking<Unit> {
        val handler =
            CoroutineExceptionHandler { _, exception -> println("Caught $exception") }
        val job = GlobalScope.launch(handler) {
            throw AssertionError()
        }
        val deferred = GlobalScope.async(handler) { throw ArithmeticException() }
        job.join()
        deferred.await()
    }

}