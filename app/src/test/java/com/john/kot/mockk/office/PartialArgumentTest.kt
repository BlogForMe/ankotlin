/**
 *
 * ClassName:      PartialArgumentTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 5:07 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 5:07 PM
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

class PartialArgumentTest {
    @Test
    fun `Partial argument matching`(){
        val car = mockk<Car>()

        every {
            car.recordTelemetry(
                speed = more(50.0),
                direction = Direction.NORTH, // here eq() is used
                lat = any(),
                long = any()
            )
        } returns Outcome.RECORDED

        car.recordTelemetry(60.0, Direction.NORTH, 51.1377382, 17.0257142)

        verify { car.recordTelemetry(60.0, Direction.NORTH, 51.1377382, 17.0257142) }

        confirmVerified(car)

    }
}