package com.kot.coroutine.dongnao

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
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