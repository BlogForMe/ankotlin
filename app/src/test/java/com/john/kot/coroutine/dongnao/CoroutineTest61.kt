package com.john.kot.coroutine.dongnao

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
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

class CoroutineTest61 {

    @Test
    fun `test flow continuation`() = runBlocking {
        (1..5).asFlow().filter {
            it % 2 == 0
        }.map {
            "string $it"
        }.collect{
            println("Collect ${it}")
        }
    }
}