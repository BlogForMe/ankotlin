/**
 *
 * ClassName:      VerificationTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 5:55 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 5:55 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.john.kot.test.mockk.office.Car
import com.john.kot.test.mockk.office.Direction
import com.john.kot.test.mockk.office.MockCls
import com.john.kot.test.mockk.office.Outcome
import io.mockk.*
import org.junit.Test

class VerificationTest {
    @Test
    fun `Verification atLeast, atMost or exactly times`() {

        val car = mockk<Car>(relaxed = true)

        car.accelerate(fromSpeed = 10, toSpeed = 20)
        car.accelerate(fromSpeed = 10, toSpeed = 30)
        car.accelerate(fromSpeed = 20, toSpeed = 30)

// all pass
        verify(atLeast = 3) { car.accelerate(allAny(), allAny()) }
        verify(atMost = 2) { car.accelerate(fromSpeed = 10, toSpeed = or(20, 30)) }
        verify(exactly = 1) { car.accelerate(fromSpeed = 10, toSpeed = 20) }
        verify(exactly = 0) {
            car.accelerate(
                fromSpeed = 30,
                toSpeed = 10
            )
        } // means no calls were performed

        confirmVerified(car)

    }


    @Test
    fun `Verification confirmation`() {
        val car = mockk<Car>()

        every { car.drive(Direction.NORTH) } returns Outcome.OK
        every { car.drive(Direction.SOUTH) } returns Outcome.OK

        car.drive(Direction.NORTH) // returns OK
        car.drive(Direction.SOUTH) // returns OK

        verify {
            car.drive(Direction.SOUTH)
            car.drive(Direction.NORTH)
        }

        confirmVerified(car) // makes sure all calls were covered with verification
    }

    @Test
    fun `Recording exclusions`() {
        val car = mockk<Car>()

        every { car.drive(Direction.NORTH) } returns Outcome.OK
        every { car.drive(Direction.SOUTH) } returns Outcome.OK

        excludeRecords { car.drive(Direction.SOUTH) }

        car.drive(Direction.NORTH) // returns OK
        car.drive(Direction.SOUTH) // returns OK

        verify {
            car.drive(Direction.NORTH)
        }

        confirmVerified(car) // car.drive(Direction.SOUTH) was excluded, so confirmation is fine with only car.drive(Direction.NORTH)
    }


    @Test
    fun `Verification timeout`(){
        mockk<MockCls> {
            every { sum(1, 2) } returns

            Thread {
                Thread.sleep(2000)
                sum(1, 2)
            }.start()

            verify(timeout = 3000) { sum(1, 2) }
        }
    }

    @Test
    fun `Returning Unit`(){
        val obj = mockk<MockCls>()

        justRun { obj.sum(any(), 3) }

        obj.sum(1, 1)
        obj.sum(1, 2)
        obj.sum(1, 3)

        verify {
            obj.sum(1, 1)
            obj.sum(1, 2)
            obj.sum(1, 3)
        }
    }
}