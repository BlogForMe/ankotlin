package com.kot.coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import org.junit.Test
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 *
 * ClassName:      Coroutine02
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/12/9
 * UpdateUser:     zh
 * UpdateDate:     2022/12/9
 * UpdateRemark:   Modify the description
 */

class CoroutineFlow {
    //    链接：https://juejin.cn/post/7041835887897870373
    @OptIn(ExperimentalTime::class)
    @Test
    fun `test select flow`() = runBlocking<Unit> {
        // 函数 -> 协程 -> Flow -> Flow合并
        val ff = measureTime {
            val name = "guest"
            coroutineScope {
                //通过作用域，将对应方法调用添加至list集合里
                listOf(::getUserFromNetwork, ::getUserFromLocal)
                    //遍历集合每个方法，function 就为对应的某个方法
                    .map { function ->
                        function.call(name) //这里调用对应方法后，将返回的结果传至下个map里
                    }.map { deferred -> //这里对应deferred 表示对应方法返回的结果
                        flow { emit(deferred.await()) }//这里表示，得到谁，就通过flow 发射值
                    }.merge() //流 合并
                    .collect { user -> println(user) } //这里只管接收flow对应发射值
            }
        }
        println("take time $ff")
    }
}


@OptIn(ExperimentalTime::class)
@Test
fun `test select flow`() = runBlocking<Unit> {
    // 函数 -> 协程 -> Flow -> Flow合并
    val ff = measureTime {
        val name = "guest"
        coroutineScope {
            //通过作用域，将对应方法调用添加至list集合里
            listOf(getUserFromNetwork(""), getUserFromLocal(""))
                //遍历集合每个方法，function 就为对应的某个方法
                /*.map { function ->
                    function.call(name) //这里调用对应方法后，将返回的结果传至下个map里
                }*/.map { deferred -> //这里对应deferred 表示对应方法返回的结果
                    flow { emit(deferred.await()) }//这里表示，得到谁，就通过flow 发射值
                }.merge() //流 合并
                .collect { user -> println(user) } //这里只管接收flow对应发射值
        }
    }
    println("take time $ff")
}

fun CoroutineScope.getUserFromLocal(str: String) = async {
    // 模拟读取本地数据
    delay(3000)
    "getUserFromLocal"
}

fun CoroutineScope.getUserFromNetwork(str: String) = async {
    // 模拟读取网络数据
    delay(6000)
    "getUserFromNetwork"
}