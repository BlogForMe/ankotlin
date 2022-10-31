package com.john.kot.ztest

/**
 *
 * ClassName:      Outer
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/10/30
 * UpdateUser:     zh
 * UpdateDate:     2022/10/30
 * UpdateRemark:   Modify the description
 */

class Outer {
    private val bar: Int = 1

    inner class Nested {
        fun foo() = 2
    }
}

fun main() {
    Outer().Nested().foo()
}