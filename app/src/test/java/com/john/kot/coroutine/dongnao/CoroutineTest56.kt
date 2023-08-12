package com.kot.coroutine.dongnao

import kotlinx.coroutines.delay
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

class CoroutineTest56 {
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

    @Test
    fun `test multiple values`() {
//        simpleList().forEach { values -> println(values) }  // 返回了多个值，但不是异步
        simpleSequence().forEach { value -> println(value) }// 返回了多个值，是同步
    }

    @Test
    fun `test multiple values2`() = runBlocking {
        simpleList2().forEach { values -> println(values) }  // 返回了多个值，是异步，但是是一次性返回的
    }
}