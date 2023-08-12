package com.kot.coroutine.dongnao

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.apache.commons.collections4.CollectionUtils.collect
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

class CoroutineTest63 {

    fun simpleFlow3() = flow<Int> {
        println("Flow started ${Thread.currentThread().name}")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }


    @Test
    fun `test flow context`() = runBlocking {
        simpleFlow3().collect {
            println("Collected $it ${Thread.currentThread().name}")
        }
    }

    fun simpleFlow4() = flow<Int> {
        withContext(Dispatchers.IO) {
            println("Flow started ${Thread.currentThread().name}")
            for (i in 1..3) {
                delay(1000)
                emit(i)
            }
        }
    }


    @Test
    fun `test flow context4`() = runBlocking {
        simpleFlow4().collect {
            println("Collected $it ${Thread.currentThread().name}")
        }
    }

    fun simpleFlow5() = flow<Int> {
        println("Flow started ${Thread.currentThread().name}")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }.flowOn(Dispatchers.Default)

    @Test
    fun `test flow context5`() = runBlocking {
        simpleFlow5().collect {
            println("Collected $it ${Thread.currentThread().name}")
        }
    }
}