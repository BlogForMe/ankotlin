/**
 *
 * ClassName:      EnumerationTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 5:02 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 5:02 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.john.kot.test.mockk.office.Enumeration
import io.mockk.every
import io.mockk.mockkObject
import org.junit.Assert.assertEquals
import org.junit.Test

class EnumerationTest {
    @Test
    fun EnumerationMocks(){
        mockkObject(Enumeration.CONSTANT)
        every { Enumeration.CONSTANT.goodInt } returns 42
        assertEquals(42, Enumeration.CONSTANT.goodInt)
    }
}