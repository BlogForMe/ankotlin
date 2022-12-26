/**
 *
 * ClassName:      CoroutineTest01
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/12/14 7:55 AM
 * UpdateUser:     zh
 * UpdateDate:     2021/12/14 7:55 AM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.coroutine.dongnao

import kotlinx.coroutines.*
import kotlinx.coroutines.selects.select
import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.system.measureTimeMillis

//https://www.bilibili.com/video/BV1uo4y1y7ZF?p=20&vd_source=d4c5260002405798a57476b318eccac9
class CoroutineTest20 {
    @Test
    fun `test coroutine join`() = runBlocking {
        val job1 = launch() {
            delay(200)
            println("One")
        }
        job1.join() // job1执行完，再执行job2 job3
        val job2 = launch() {
            delay(200)
            println("Two")
        }
        val job3 = launch() {
            delay(200)
            println("Three")
        }
    }

    @Test
    fun `test coroutine await`() = runBlocking {
        // 刷新界面，拿到执行结果后，再执行其他的。
        val job1 = async() {
            delay(100)
            println("One")
        }
        job1.await() // job1执行完，再执行job2 job3

        val job2 = async() {
            delay(200)
            println("Two")
        }


        val job3 = async() {
            delay(200)
            println("Three")
        }
    }

    @Test
    fun `test sync`() = runBlocking {
        val time = measureTimeMillis {
            val one = doOne()
            val two = doTwo()
            println("The result : ${one + two}")
        }
        println("completed in $time ms")
    }

    @Test
    fun `test combine async`() = runBlocking {
        val time = measureTimeMillis {
            val one = async { doOne() }
            val two = async { doTwo() }
            println("total before")

            one.await()
            println("total one")

            two.await()
//            println("The result : ${one.await() + two.await()}")
            println("total two")
        }
        println("completed in $time ms")
    }


    // https://juejin.cn/post/7041835887897870373
    @Test
    fun `test combine select`() = runBlocking {
        val time = measureTimeMillis {
            val remote = async { doRemote() }
            val local = async { doLocal() }
            val select = select<Int> {
                remote.onAwait
                local.onAwait
            }
            println(select)
        }
//        println("completed in $time ms")
    }


    private suspend fun doRemote(): Int {
        delay(2000)
        println("doOne")
        return 14
    }

    private suspend fun doLocal(): Int {
        delay(1000)
        println("doTwo")
        return 25
    }

    private suspend fun doOne(): Int {
        delay(2000)
        println("doOne")
        return 14
    }

    private suspend fun doTwo(): Int {
        delay(1000)
        println("doTwo")
        return 25
    }


}