/**
 *
 * ClassName:      ObjectMoack
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 1:53 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 1:53 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.john.kot.test.mockk.office.ObjBeingMocked
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class ObjectMock {
    @Before
    fun beforeTests() {
        mockkObject(ObjBeingMocked)
        every { ObjBeingMocked.add(1,2) } returns 55
    }

    @Test
    fun willUseMockBehaviour() {
        assertEquals(55, ObjBeingMocked.add(1,2))
    }

    @After
    fun afterTests() {
        unmockkAll()
        // or unmockkObject(ObjBeingMocked)
    }




    @Test
    fun `objects mock`(){
        mockkObject(ObjBeingMocked) // applies mocking to an Object

        assertEquals(3, ObjBeingMocked.add(1, 2))

        every { ObjBeingMocked.add(1, 2) } returns 55

        assertEquals(55, ObjBeingMocked.add(1, 2))
    }
}