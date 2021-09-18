/**
 *
 * ClassName:      AnonymousFunc
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/10 2:57 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/10 2:57 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.test

//传入一个具名函数，被调用后，获取参数
fun test(resModel: ResModel){
    println(resModel.int)
}

class LoginModelImpl {
    fun loginOptions(
        mobileNo: String,
        metaInfo: String,
        block: (model: ResModel) -> Unit
    ) {
        val model = ResModel(8)
//        block(model)
        block.invoke(model)     //这样写也可以
    }
}

class ResModel(val int: Int)