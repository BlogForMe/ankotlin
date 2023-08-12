/**
 *
 * ClassName:      CarTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 12:03 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 12:03 PM
 * UpdateRemark:   Modify the description
 */

package com.kot.mockk.office

import com.kot.test.mockk.office.Car
import com.kot.test.mockk.office.TrafficSystem
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import org.junit.Before
import org.junit.Test

class CarTest {
    @MockK
    lateinit var car1: Car

    @RelaxedMockK
    lateinit var car2: Car

    @MockK(relaxUnitFun = true)
    lateinit var car3: Car

    @SpyK
    var car4 = Car()

    @InjectMockKs
    var trafficSystem = TrafficSystem()

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks

    @Test
    fun calculateAddsValues1() {
        // ... use car1, car2, car3 and car4
    }
}