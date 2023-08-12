/**
 *
 * ClassName:      PrivateFunction
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 9:27 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 9:27 PM
 * UpdateRemark:   Modify the description
 */

package com.kot.mockk.office

import com.kot.test.mockk.office.Car
import com.kot.test.mockk.office.Team
import io.mockk.every
import io.mockk.just
import io.mockk.justRun
import io.mockk.runs
import io.mockk.spyk
import io.mockk.verify
import io.mockk.verifySequence
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Private functions mocking / dynamic calls

IF you need to mock private functions, you can do it via a dynamic call.
 */
class PrivateFunction {
    @Test
    fun `Private functions mocking  dynamic calls`(){
        val mock = spyk<Car>(recordPrivateCalls = true)

        every { mock["accelerate"]() } returns "going not so fast"

        assertEquals("going not so fast", mock.drive())

        verifySequence {
            mock.drive()
            mock["accelerate"]()
        }
    }

    @Test
    fun `you should create a spyk with recordPrivateCalls = true`(){
        val mock = spyk(Team(), recordPrivateCalls = true)

        every { mock getProperty "speed" } returns 33
        every { mock setProperty "acceleration" value less(5) } just runs
        justRun { mock invokeNoArgs "privateMethod" }
        every { mock invoke "openDoor" withArguments listOf("left", "rear") } returns "OK"

        verify { mock getProperty "speed" }
        verify { mock setProperty "acceleration" value less(5) }
        verify { mock invoke "openDoor" withArguments listOf("left", "rear") }

    }
}