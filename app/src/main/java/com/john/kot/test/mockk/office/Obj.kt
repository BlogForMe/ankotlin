/**
 *
 * ClassName:      Obj
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 9:11 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 9:11 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.test.mockk.office

data class Obj(val value: Int)

class Ext {
    fun Obj.extensionFunc() = value + 5
}

fun Obj.extensionFunc() = value + 5