package com.kot.coroutine

import kotlinx.coroutines.*
import java.text.SimpleDateFormat

/**
 *
 * ClassName:      CoroutinesTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/5/29 10:20 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/5/29 10:20 PM
 * UpdateRemark:   Modify the description
 */

val dateFormat = SimpleDateFormat("HH:mm:SSS")
val currentTime = {
    dateFormat.format(System.currentTimeMillis())
}

//fun log(msg: Int) = println("[${currentTime()}   ${Thread.currentThread().name}]   $msg")
suspend fun log(msg: Int) = println("[${currentTime()}   ${currentCoroutineContext()}]   $msg")


@OptIn(DelicateCoroutinesApi::class)
suspend fun main() {
    log(1)
    val job = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
        log(2)
        delay(500)
        log(5)
    }
    log(3)
    job.cancel()
//    Thread.sleep(3000)
    log(4)

}