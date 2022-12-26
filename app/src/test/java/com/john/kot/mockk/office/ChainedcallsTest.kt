/**
 *
 * ClassName:      ChainedcallsTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 5:47 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 5:47 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.john.kot.test.mockk.office.Car
import com.john.kot.test.mockk.office.DoorType
import com.john.kot.test.mockk.office.MockCls
import com.john.kot.test.mockk.office.WindowState
import io.mockk.*
import org.junit.Test

class ChainedcallsTest {
    @Test
    fun `Chained calls`() {
        val car = mockk<Car>()

        every { car.door(DoorType.FRONT_LEFT).windowState() } returns WindowState.UP

        car.door(DoorType.FRONT_LEFT) // returns chained mock for Door
        car.door(DoorType.FRONT_LEFT).windowState() // returns WindowState.UP

        verify { car.door(DoorType.FRONT_LEFT).windowState() }

        confirmVerified(car)

    }


    @Test
    fun `Verification order`() {
        val obj = mockk<MockCls>()
        val slot = slot<Int>()

        every {
            obj.sum(any(), capture(slot))
        } answers {
            1 + firstArg<Int>() + slot.captured
        }

        obj.sum(1, 2) // returns 4
        obj.sum(1, 3) // returns 5
        obj.sum(2, 2) // returns 5

        verifyAll {
            obj.sum(1, 3)
            obj.sum(1, 2)
            obj.sum(2, 2)
        }

        verifySequence {
            obj.sum(1, 2)
            obj.sum(1, 3)
            obj.sum(2, 2)
        }

        verifyOrder {
            obj.sum(1, 2)
            obj.sum(2, 2)
        }

        val obj2 = mockk<MockCls>()
        val obj3 = mockk<MockCls>()
        verify {
            listOf(obj2, obj3) wasNot Called
        }

        confirmVerified(obj)
    }
}