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

package com.kot.coroutine.dongnao

import android.util.Log
import io.mockk.verify
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select
import kotlinx.coroutines.withContext
import org.junit.Test
import kotlin.system.measureTimeMillis

//https://www.bilibili.com/video/BV1uo4y1y7ZF?p=20&vd_source=d4c5260002405798a57476b318eccac9
class CoroutineTest20 {
    @Test
    fun `test coroutine join`() = runBlocking {
//        val job1 = launch() {
//            delay(200)
//            println("One")
//        }
//        job1.join() // job1执行完，再执行job2 job3
//        val job2 = launch() {
//            delay(200)
//            println("Two")
//        }
//        val job3 = launch() {
//            delay(200)
//            println("Three")
//        }

        val deferreds: List<Deferred<Int>> = (1..3).map {
            async {
                delay(1000L * it)
                println("Loading $it")
                it
            }
        }
        val sum = deferreds.awaitAll().sum()
        println("$sum")
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

            println("total one ${one.await()}")

//            println("The result : ${one.await() + two.await()}")
            println("total two ${two.await()}")
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


    @Test
    fun mainThreadDelayTest() {
        //在主线程执行协程
        println("fish before suspend thread:${Thread.currentThread()}")
        //执行挂起函数
        GlobalScope.launch {
            getStuInfo()
        }


//        GlobalScope.launch(Dispatchers.Main) {
//            coDelay(2000)
////            在主线程执行协程
//            Log.d("fish", "before suspend thread:${Thread.currentThread()}")
////            执行挂起函数
//        }

        //延迟2s在主线程执行打印
        println("fish post thread:${Thread.currentThread()}")


        Thread.sleep(6000)
    }

    private suspend fun coDelay(i: Int) {
        delay(2000)
    }

    suspend fun getStuInfo() {
        delay(5000)
        println("fish after delay thread:${Thread.currentThread()}")
    }

//    作者：小鱼人爱编程
//    链接：https://juejin.cn/post/7111246680338464804


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
        Thread.sleep(3000)
        println("doOne")
        return 14
    }

    private suspend fun doTwo(): Int {
        Thread.sleep(4000)
        println("doTwo")
        return 25
    }



    @Test
    fun withContextTest(){
        verify() {  }
        GlobalScope.launch() {
            println("before suspend  ${Thread.currentThread().name}")
            //挂起函数
            var studentInfo = getStuInfo2()
            //挂起函数执行返回
            println("after suspend student name:${studentInfo}   ${Thread.currentThread().name}")
        }
        //防止进程退出
        Thread.sleep(10000)
    }

    suspend fun getStuInfo2():String {
        return withContext(Dispatchers.IO) {
            println("start get studentInfo  ${Thread.currentThread().name}")
            //模拟耗时操作
            Thread.sleep(3000)
            println("get studentInfo successful")
            //返回学生信息
            "StudentInfo()"
        }
    }



}