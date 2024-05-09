package com.kot.coroutine.dongnao

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
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


    @Test
    fun SupervisorJobTest(){
        val supervisorJob = SupervisorJob()
        val scope = CoroutineScope(Dispatchers.IO + supervisorJob)

        val job1 = scope.launch {
//            while(isActive) {
                delay(2000)
                println("SupervisorJobTest job1")
//            }
        }

        val job2 = scope.launch {
            println("SupervisorJobTest job2")
            throw Exception()
        }

        val job3 = scope.launch {
//            while(isActive) {
                delay(2000)
                println("SupervisorJobTest job3")
//            }
        }

        Thread.sleep(3000)


    }



}