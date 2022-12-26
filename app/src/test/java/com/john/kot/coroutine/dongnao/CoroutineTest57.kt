package com.john.kot.coroutine.dongnao

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

class CoroutineTest57 {
    suspend fun simpleFlow() = flow<Int> {
        for (i in 1..3) {
            delay(1000) // 怎么证明没有阻塞，而是挂起
            emit(i) // 发生，产生一个元素
        }
    }

    @Test
    fun `test multiple values3`() = runBlocking {
        launch {
            for (k in 1..3){
                println("I am not blocked $k")
                delay(1500)
            }
        }
        simpleFlow().collect { value -> println(value) }
    }
}