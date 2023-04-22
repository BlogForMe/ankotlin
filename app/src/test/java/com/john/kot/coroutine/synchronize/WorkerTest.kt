package com.john.kot.coroutine.synchronize

import kotlinx.coroutines.*
import org.junit.Test
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.system.measureTimeMillis


internal class WorkerTest {

    @Test
    fun doSomething() {
        val worker = Worker()
        /*Async Operation*/

        /*Callback to get notified regarding the result*/
//        val listener = object : Worker.Listener {
//            override fun onSuccess(msg: String) {
//                println(msg)
//            }
//
//            override fun onError(e: Exception) {
//                e.printStackTrace()
//                println(e.message)
//            }
//        }
//        /*Do some work, don't throw exception*/
//        worker.doSomething(listener, false)
//        /*Do some work, throw exception*/
//        worker.doSomething(listener, true)


        runBlocking {
            val time = measureTimeMillis {
                /*Async to Sync Operation*/
                try {
                    /*Do some work, don't throw exception*/
                    val doSomethingSync = async() { worker.doSomethingSync(false) }
                    val doSomethingSync1 = async { worker.doSomethingSync(false) }

//                    val doSomethingSync = async { worker.doSomethingSync(false) }
//                    val doSomethingSync1 = async { worker.doSomethingSync(false) }
//
//                    doSomethingSync1.await()
//                    doSomethingSync.await()

                    println("doSomethingSync $doSomethingSync")
                    println("doSomethingSync1 $doSomethingSync1")
                    /*Do some work, throw exception*/
                } catch (e: Exception) {
                    e.printStackTrace()
                    println(e.message)
                }
            }
            println("doSomething time $time")
        }
    }

    @Test
    fun suspendCoroutineTest() {
        runBlocking {
            val doSomethingSync1 =
                GlobalScope.async {
                    suspendCoroutine { cout ->
                        cout.resume(42)
                    }
                }
            val doSomethingSync2 = async { suspendCoroutine { cout -> cout.resume("Some text") } }
            println("doSomethingSync $doSomethingSync1")
            println("doSomethingSync1 $doSomethingSync2")
        }
    }
}