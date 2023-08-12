/**
 *
 * ClassName:      KidMock3
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/5 11:48 AM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/5 11:48 AM
 * UpdateRemark:   Modify the description
 */

package com.kot.mockk.joetsaitw

import com.kot.test.mockk.Kid
import com.kot.test.mockk.Mother
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.just
import io.mockk.slot
import io.mockk.verify
import io.mockk.verifyOrder
import io.mockk.verifySequence
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class KidMockk3 {
    @MockK(relaxUnitFun = true)
    lateinit var mother: Mother

    lateinit var kid: Kid

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        kid = Kid(mother)
    }


    @Test
    fun wantMoney() {
        kid.wantMoney1()

        verify(exactly = 1) { mother.inform(any()) }
        verify(exactly = 2) { mother.inform(any()) }
    }


    @Test
    fun `capture params`() {
        // Given
// Given
        val slot = slot<Int>()
        every { mother.inform(capture(slot)) } just Runs
// When
        kid.wantMoney1()

        verifySequence {
            mother.inform(any())
            mother.giveMoney()
        }
        verifyOrder {
            mother.inform(any())
            mother.giveMoney()
        }
//        verifyOrder {
//            mother.giveMoney()
//            mother.inform(any())
//        }

// Then
//        assertEquals(0, slot.captured)
        assertEquals(10, slot.captured)

    }
}