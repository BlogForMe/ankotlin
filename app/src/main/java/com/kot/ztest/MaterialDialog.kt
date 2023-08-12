/**
 *
 * ClassName:      MaterialDialog
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/10/6 3:47 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/10/6 3:47 PM
 * UpdateRemark:   Modify the description
 */

package com.kot.ztest

class MaterialDialog{
    fun show(func: MaterialDialog.() -> Unit): MaterialDialog = apply {
        func()
    }

    fun method1(){
        println("1 ")
    }

    fun method2(){
        println("2 ")
    }

}

