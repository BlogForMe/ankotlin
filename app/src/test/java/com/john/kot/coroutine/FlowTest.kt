package com.john.kot.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 *
 * ClassName:      FlowTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/12/13
 * UpdateUser:     zh
 * UpdateDate:     2022/12/13
 * UpdateRemark:   Modify the description
 */

class FlowTest {


    @Test
    fun flowTest() {
//        flow {
//            // 向下游发射100
//            emit(100)
//            // 向下游发射200
//            emit(200)
//        }.collect {
//            println("output $it")
//        }

//        作者：李萧蝶
//        链接：https://juejin.cn/post/7149865653380317192
//        来源：稀土掘金
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }


    fun simpleFlow2() = flow<Int> {
        println("Flow started")
        for (i in 1..3) {
            delay(1000) // 怎么证明没有阻塞，而是挂起
            emit(i) // 发生，产生一个元素
        }
    }

    @Test
    fun `test flow is cold`() = runBlocking {
        val flow = simpleFlow2()
        println("Calling collect...")
        flow.collect { value -> println(value) }
        println("Calling collect again")
        flow.collect { value -> println(value) }
    }

    @Test
    fun `test multiple values`() {
//        simpleList().forEach { values -> println(values) }  // 返回了多个值，但不是异步
        simpleSequence().forEach { value -> println(value) }// 返回了多个值，是同步
    }

    @Test
    fun `test multiple values2`() = runBlocking {
        simpleList2().forEach { values -> println(values) }  // 返回了多个值，是异步，但是是一次性返回的
    }


    suspend fun simpleFlow() = flow<Int> {
        for (i in 1..3) {
            delay(1000) // 怎么证明没有阻塞，而是挂起
            emit(i) // 发生，产生一个元素
        }
    }

    @Test
    fun `test multiple values3`() = runBlocking {
        launch {            //再起一个任务，确认线程是否阻塞
            for (k in 1..3) {
                println("I am not blocked $k")
                delay(1500)
            }
        }
        simpleFlow().collect { value -> println(value) }
    }



    fun simpleList(): List<Int> = listOf(1, 2, 3)


    fun simpleSequence(): Sequence<Int> = sequence {
        for (i in 1..3) {
//            Thread.sleep(1000) // 阻塞，假装在计算
//            delay(1000)
            yield(i)
        }
    }

    suspend fun simpleList2(): List<Int> {
        delay(1000)
        return listOf(1, 2, 3)
    }
}