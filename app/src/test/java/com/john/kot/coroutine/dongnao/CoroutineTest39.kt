package com.kot.coroutine.dongnao

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

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

class CoroutineTest39 {

    @Test
    fun `test CoroutineContext `() = runBlocking<Unit> {
        launch (Dispatchers.Default + CoroutineName("test")){
            println("you are great ${Thread.currentThread().name}")
        }
    }
}