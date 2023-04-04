package com.john.kot.coroutine.synchronize

/**
 *
 * ClassName:      Worker
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/4
 * UpdateUser:     zh
 * UpdateDate:     2023/4/4
 * UpdateRemark:   Modify the description
 */

class Worker {
    /*Async API*/
    fun doSomething(listener: Listener, throwError: Boolean) {
        when (throwError) {
            true -> {
                Thread.sleep(3000)
                listener.onError(Exception("Just a random exception..."))
            }
            else -> {
                Thread.sleep(3000)
                listener.onSuccess("Success")
            }
        }
    }

    interface Listener {
        fun onSuccess(msg: String)
        fun onError(e: Exception)
    }
}

//suspend fun Worker.doSomethingSync(throwError: Boolean): String {
//    return suspendCoroutine {
//        doSomething(object : Worker.Listener {
//            override fun onSuccess(msg: String) {
//                it.resume("Success")
//            }
//
//            override fun onError(e: Exception) {
//                it.resumeWithException(e)
//            }
//
//        }, throwError)
//    }
//}
