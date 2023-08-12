package com.kot.coroutine.dongnao

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 *
 * ClassName:      CoroutineTest56
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/7/31 6:44 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/7/31 6:44 PM
 * UpdateRemark:   Modify the description
 */

class CoroutineTest60 {
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
}