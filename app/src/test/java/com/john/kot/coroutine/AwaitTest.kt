package com.kot.coroutine

import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select
import org.junit.Test

/**
 *
 * ClassName:      Await
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/12/13
 * UpdateUser:     zh
 * UpdateDate:     2022/12/13
 * UpdateRemark:   Modify the description
 */

class AwaitTest {

    @Test
    fun testSelect4() {
        runBlocking {
            val bitmap = null;
            val starTime = System.currentTimeMillis()
            val receiveChannelZxing = produce {
                //生产数据
                val result = getQrcodeInfoFromZxing(bitmap)
                //发送数据
                send(result)
            }

            val receiveChannelZbar = produce {
                val result = getQrcodeInfoFromZbar(bitmap)
                send(result)
            }

            val result = select<String> {
                //监听是否有数据发送过来
                receiveChannelZxing.onReceive { value ->
                    "zxing result $value"
                }

                receiveChannelZbar.onReceive { value ->
                    "zbar result $value"
                }
            }

            println("result from $result useTime:${System.currentTimeMillis() - starTime}")
        }
    }

    private fun getQrcodeInfoFromZxing(bitmap: Nothing?) = "FromZxing"
    private fun getQrcodeInfoFromZbar(bitmap: Nothing?) = "FromZbar"
}
