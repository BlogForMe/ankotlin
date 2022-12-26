/**
 *
 * ClassName:      CustomMatchers
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 10:20 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 10:20 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.google.common.base.Verify.verify
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class CustomMatchers {
    @Test
    fun test(){
        class MockCls {
            fun op(a: List<Int>) = a.reversed()
        }

        val mock = mockk<MockCls>()

        every { mock.op(any()) } returns listOf(5, 6, 9)

        println(mock.op(listOf(1, 2, 3)))

//     verify { mock.op(matchListWithoutOrder(3, 2, 1)) }
    }
}