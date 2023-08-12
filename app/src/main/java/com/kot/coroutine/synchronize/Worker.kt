package com.kot.coroutine.synchronize

import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *
 * ClassName:      Worker
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/4
 * UpdateUser:     zh
 * UpdateDate:     2023/4/4
 * UpdateRemark:    https://rommansabbir.com/kotlin-coroutine-convert-async-apis-into-sync the description
 */
class Worker {
    /*Async API*/
    fun doSomething(listener: Listener, throwError: Boolean) {
        when (throwError) {
            true -> {
//                delay(4000)
                listener.onError(Exception("Just a random exception..."))
            }
            else -> {
//                delay(4000)
                listener.onSuccess("Success")
            }
        }
    }

    interface Listener {
        fun onSuccess(msg: String)
        fun onError(e: Exception)
    }
}


suspend fun doSomethingSync(throwError: Boolean): String {
    return suspendCoroutine {
        Worker().doSomething(object : Worker.Listener {
            override fun onSuccess(msg: String) {
                it.resume("Success")
            }

            override fun onError(e: Exception) {
                it.resumeWithException(e)
            }

        }, throwError)
    }
}
