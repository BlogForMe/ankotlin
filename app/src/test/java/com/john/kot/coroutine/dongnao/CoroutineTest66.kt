package com.john.kot.coroutine.dongnao

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

class CoroutineTest66 {

    fun simpleFlow7() = flow<Int> {
        for (i in 1..5) {
            delay(1000)
            emit(i)
            println("Emitting $i")
        }
    }

    @Test
    fun `test cancel flow check`() = runBlocking<Unit> {
        withTimeoutOrNull(2500) { // 2.5s超时
            simpleFlow7().collect { value ->
                println(value)
                if (value == 3) cancel()
            }
        }
    }
}