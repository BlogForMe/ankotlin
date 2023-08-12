/**
 *
 * ClassName:      DslExmaples
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 11:51 AM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 11:51 AM
 * UpdateRemark:   Modify the description
 */

package com.kot.mockk.office

import com.kot.test.mockk.office.Car
import com.kot.test.mockk.office.Direction
import com.kot.test.mockk.office.Outcome
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class DslExmaples {

    @Test
    fun `DSL examples Simplest example By default mocks are strict, so you need to provide some behaviour`() {
        val car = mockk<Car>()
        every {
            car.drive(Direction.NORTH)
        } returns Outcome.OK

        car.drive(Direction.NORTH) // returns OK
        verify { car.drive(Direction.NORTH) }
        confirmVerified(car)
    }




}