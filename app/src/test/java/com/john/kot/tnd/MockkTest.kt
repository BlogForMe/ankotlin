/**
 *
 * ClassName:      MockkTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/2 2:37 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/2 2:37 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.tnd

import com.google.gson.Gson
import com.john.kot.list.Person
import com.john.kot.test.mockk.Son1
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.mockkStatic
import junit.framework.Assert.assertEquals
import org.junit.Test

class MockkTest {

    @Test
    fun test1() {
        val mother = mockk<Person>()
        every { mother.age } returns 29 // when().thenReturn() in Mockito
        assertEquals(29, mother.age)
    }

    @Test
    fun `mockkObject `() {
        mockkObject(Son1)
        every { Son1.test5() } returns 10
        assertEquals(10, Son1.test5())
    }


    @Test
    fun `mockkStatic `() {
        mockkStatic(com.kot.test.mockk.Parent::class)
        every { com.kot.test.mockk.Parent.test5() } returns 10
        assertEquals(10, com.kot.test.mockk.Parent.test5())
    }

    @Test
    fun `testt`() {
        val test = "{\"id\":123,\"name\":\"wenshao\"}"
        val fromJson = Gson().fromJson(test, DataModel::class.java)
        println(fromJson)
    }

}
