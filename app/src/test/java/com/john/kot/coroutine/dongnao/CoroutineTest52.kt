package com.kot.coroutine.dongnao

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield
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

class CoroutineTest52 {

    @Test
    fun `test cancel and exception`() = runBlocking {
        val job = launch {
            val child = launch {
                try {
                    try {
                        delay(Long.MAX_VALUE)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } finally {
                    println("Child is cancelled.")
                }
            }
            yield()
            println("Cancelling child")
            child.cancelAndJoin()
            yield()
            println("Parent is cancelled.")
        }
        job.join()
    }

    @Test
    fun `test cancel and exception2`() = runBlocking {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("Caught $exception")
        }
        val job = GlobalScope.launch(handler) {
            launch {
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    withContext(NonCancellable){
                        println("Children are cancelled , but exception is not handled until ")
                        delay(100)
                        println("The first child finished its non cancellable block")
                    }
                }
            }

            launch {
                delay(10)
                println("Second child throws an exception")
                throw ArithmeticException()
            }
        }
        job.join()
    }

}