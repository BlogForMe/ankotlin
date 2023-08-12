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

class CoroutineTest64 {

    fun events() = (1..3)
        .asFlow()
        .onEach { delay(100) }
        .flowOn(Dispatchers.Default)


    @Test
    fun `test flow launch`() = runBlocking<Unit> {
        val job =
            events().onEach { events -> println("Event: $events ${Thread.currentThread().name}") }
//            .collect()
                .launchIn(CoroutineScope(Dispatchers.IO)) // 单独的协程中，启动流的收集
                .join()
        delay(200)

//        job.cancelAndJoin()
    }
}