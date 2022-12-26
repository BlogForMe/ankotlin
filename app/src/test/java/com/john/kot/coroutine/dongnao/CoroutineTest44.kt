package com.john.kot.coroutine.dongnao

import kotlinx.coroutines.*
import org.junit.Test
import java.lang.IllegalArgumentException

/**
 *
 * ClassName:      Coroutine26
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/7/28 9:17 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/7/28 9:17 PM
 * UpdateRemark:   Modify the description
 */

class CoroutineTest44 {

    @Test
    fun `test CoroutineContext `() = runBlocking<Unit> {
        val scope = CoroutineScope(Job())
        val job = scope.launch {
            throw IllegalArgumentException()
            //如果async抛出异常，launch就会立即抛出异常，而需要调用 .await
        }
        job.join()
    }
}