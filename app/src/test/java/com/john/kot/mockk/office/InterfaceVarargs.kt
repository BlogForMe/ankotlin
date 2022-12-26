/**
 *
 * ClassName:      InterfaceVarargs
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 9:25 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 9:25 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.john.kot.test.mockk.office.ClsWithManyMany
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

/**
 * Varargs

From version 1.9.1, more extended vararg handling is possible:
 */
class InterfaceVarargs {
    @Test
    fun `more extended vararg handling is possible`(){
        val obj = mockk<ClsWithManyMany>()

        every { obj.manyMany(5, 6, *varargAll { it == 7 }) } returns 3

        println(obj.manyMany(5, 6, 7)) // 3
        println(obj.manyMany(5, 6, 7, 7)) // 3
        println(obj.manyMany(5, 6, 7, 7, 7)) // 3

        every { obj.manyMany(5, 6, *anyVararg(), 7) } returns 4

        println(obj.manyMany(5, 6, 1, 7)) // 4
        println(obj.manyMany(5, 6, 2, 3, 7)) // 4
        println(obj.manyMany(5, 6, 4, 5, 6, 7)) // 4

        every { obj.manyMany(5, 6, *varargAny { nArgs > 5 }, 7) } returns 5

        println(obj.manyMany(5, 6, 4, 5, 6, 7)) // 5
        println(obj.manyMany(5, 6, 4, 5, 6, 7, 7)) // 5

        every {
            obj.manyMany(5, 6, *varargAny {
                if (position < 3) it == 3 else it == 4
            }, 7)
        } returns 6

        println(obj.manyMany(5, 6, 3, 4, 7)) // 6
        println(obj.manyMany(5, 6, 3, 4, 4, 7)) // 6
    }
}