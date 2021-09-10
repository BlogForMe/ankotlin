/**
 *
 * ClassName:      MockCls
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 2:02 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 2:02 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.test.mockk.office

class MockCls(private val a: Int = 0) {
    constructor(x: String) : this(x.toInt())

    fun add(a: Int, b: Int) = a + b

    fun add(b: Int) = a + b

    fun sum(a: Int, b: Int) = println(a + b)

}