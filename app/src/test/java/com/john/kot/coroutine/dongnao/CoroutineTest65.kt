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

class CoroutineTest65 {

    fun simpleFlow6() = flow<Int> {
        println("Flow started ${Thread.currentThread().name}")
        for (i in 1..3) {
            delay(1000)
            emit(i)
            println("Emitting $i")
        }
    }.flowOn(Dispatchers.Default)

    @Test
    fun `test cancel flow`() = runBlocking<Unit> {
        withTimeoutOrNull(2500){ // 2.5s超时
            simpleFlow6().collect{value-> println(value)}
        }
        println("Done")
    }
}