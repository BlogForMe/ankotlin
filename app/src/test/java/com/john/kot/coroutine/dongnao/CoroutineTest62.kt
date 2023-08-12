package com.kot.coroutine.dongnao

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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

class CoroutineTest62 {

    @Test
    fun `test flow continuation`() = runBlocking {
        flowOf("one", "two", "three")
            .onEach { delay(1000) }
            .collect {
                println(it)
            }

        (1..3).asFlow().collect {
            println(it)
        }
    }
}