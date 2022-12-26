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

class CoroutineTest47 {

    @Test
    fun `test SupervisorJob `() = runBlocking<Unit> {
        val child = supervisorScope {
            launch {
                try {
                    println("The child is sleeping")
                    delay(Long.MAX_VALUE)
                } finally {
                    println("The child is cancelled")
                }
            }
            yield()
            println("Throwing an exception from the scope")
            throw AssertionError()
        }


    }

}