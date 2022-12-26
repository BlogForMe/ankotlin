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

class CoroutineTest49 {

    @Test
    fun `test SupervisorJob `() = runBlocking<Unit> {
        val handler =
            CoroutineExceptionHandler { _, exception -> println("Caught $exception") }
        val scope = CoroutineScope(Job())
        val job = scope.launch(handler) {
            launch {
                throw IllegalArgumentException()
            }
        }
        job.join()
    }
    @Test
    fun `test SupervisorJob 2 `() = runBlocking<Unit> {
        val handler =
            CoroutineExceptionHandler { _, exception -> println("Caught $exception") }
        val scope = CoroutineScope(Job())
        val job = scope.launch {
            launch(handler) {
                throw IllegalArgumentException()
            }
        }
        job.join()
    }

}