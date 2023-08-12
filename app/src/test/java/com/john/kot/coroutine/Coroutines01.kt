package com.kot.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 * ClassName:      Coroutines01
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/6/18 9:49 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/6/18 9:49 PM
 * UpdateRemark:   Modify the description
 */

fun main() {
    GlobalScope.launch {
        log(1)
        withContext(Dispatchers.IO) {
            log(2)
        }
        log(3)
    }

    Thread.sleep(2000)
}