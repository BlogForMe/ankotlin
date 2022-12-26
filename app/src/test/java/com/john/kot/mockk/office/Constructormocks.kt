/**
 *
 * ClassName:      Constructormocks
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 2:02 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 2:02 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.john.kot.test.mockk.office.MockCls
import io.mockk.*
import org.junit.Assert.assertEquals
import org.junit.Test

class Constructormocks {
    @Test
    fun ` you need to mock newly created objects`(){
        mockkConstructor(MockCls::class)

        every { anyConstructed<MockCls>().add(1, 2) } returns 4

        assertEquals(4, MockCls().add(1, 2)) // note new object is created

        verify { anyConstructed<MockCls>().add(1, 2) }
    }

    @Test
    fun `mock different constuctor`(){
        mockkConstructor(MockCls::class)

        every { constructedWith<MockCls>().add(1) } returns 2
        every {
            constructedWith<MockCls>(OfTypeMatcher<String>(String::class)).add(2) // Mocks the constructor which takes a String
        } returns 3
        every {
            constructedWith<MockCls>(EqMatcher(4)).add(any()) // Mocks the constructor which takes an Int
        } returns 4

        assertEquals(1, MockCls().add(1))
        assertEquals(3, MockCls("2").add(2))
        assertEquals(4, MockCls(4).add(7))

        verify {
            constructedWith<MockCls>().add(2)
            constructedWith<MockCls>(EqMatcher("2")).add(2)
            constructedWith<MockCls>(EqMatcher(4)).add(7)
        }
    }

}