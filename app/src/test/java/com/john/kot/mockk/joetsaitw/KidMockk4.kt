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

package com.john.kot.mockk.joetsaitw

import com.john.kot.list.Person
import com.john.kot.test.mockk.Util
import com.john.kot.test.mockk.UtilJava
import com.john.kot.test.mockk.UtilKotlin
import com.john.kot.test.mockk.UtilKotlin1
import io.mockk.*
import org.junit.Assert.assertEquals
import org.junit.Test

class KidMockk4 {

    @Test
    fun ok() {
        // Given
        val util = Util()
        mockkStatic(UtilJava::class)
        mockkStatic(UtilKotlin::class)
        every { UtilJava.ok() } returns "Joe"
        every { UtilKotlin.ok() } returns "Tsai"

        // When
        util.ok()

        // Then
        verify { UtilJava.ok() }
        verify { UtilKotlin.ok() }

        assertEquals("Joe", UtilJava.ok())
        assertEquals("Tsai", UtilKotlin.ok())

    }


    @Test
    fun ok1() {
        // Given
        val util = Util()
        mockkObject(UtilKotlin1)
        mockkObject(UtilKotlin1.Companion)

        every { UtilKotlin1.ok1() } returns "Tsai"

        // When
        util.ok()

        // Then
        verify { UtilKotlin1.ok1() }
        assertEquals("Tsai", UtilKotlin1.ok1())
    }


}