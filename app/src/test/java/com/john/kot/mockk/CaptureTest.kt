/**
 *
 * ClassName:      CaptureTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/10 2:59 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/10 2:59 PM
 * UpdateRemark:   Modify the description
 */

package com.kot.mockk

import com.kot.test.LoginModelImpl
import com.kot.test.ResModel
import io.mockk.slot
import io.mockk.verify
import org.junit.Test

class CaptureTest {

    val callback = slot<(ResModel)->Unit>()

    @Test
    fun `test capture function`(){
        val loginModelImpl = LoginModelImpl()
        val responseModel = ResModel(0)
//        loginModelImpl.loginOptions("","",::test) // 可以看到 fun test(resModel: ResModel)也被调用,可以理解被回调
//    loginModelImpl.loginOptions("","",{model: ResModel -> model.toString() })
//    loginModelImpl.loginOptions("","",{model -> model.toString() })
        loginModelImpl.loginOptions("","",{println(it.int)}) //lambda只有一个参数，传入参数也可以省略,{}里面用it代替
//    loginModelImpl.loginOptions("","",{}) // it可以用也可以不用

        verify {
            loginModelImpl.loginOptions("","",capture(callback))
        }
        val invoke = callback.captured
//        invoke(ResModel(10))
        invoke.invoke(ResModel(10))
    }
}

//传入一个具名函数，被调用后，获取参数
fun test(resModel: ResModel){
    println(resModel.int)
}