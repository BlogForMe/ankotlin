package com.kot.coroutine

import kotlinx.coroutines.*
import org.junit.Test

/**
 *
 * ClassName:      RunBlocking
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/11/2
 * UpdateUser:     zh
 * UpdateDate:     2022/11/2
 * UpdateRemark:   Modify the description
 */

//链接：https://juejin.cn/post/7091443219505872904

class RunBlockingTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun delayTest() {
        runBlocking {
            println("coroutine start")
            //模拟耗时
            GlobalScope.launch {
                println("delay start")
                delay(6000)
                println("delay end")
            }
            println("coroutine end")
        }
        println("process end")
    }

    //    原文链接：https://blog.csdn.net/u011133887/article/details/98617852
    @Test
    fun main2_1() {
        println("runBlocking before ${Thread.currentThread()}")
//        runBlocking {
//            println("runBlocking launch before ${Thread.currentThread()}")
//            launch {
//                // 在后台启动一个新的协程并继续
//                println("runBlocking launch ${Thread.currentThread()}")
//                delay(3000L)
////                println("World!")
//            }
//        }
        Thread.sleep(4000)
        println("runBlocking after launch ${Thread.currentThread()}")
    }
}