/**
 *
 * ClassName:      KidAnnotationTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/4 3:46 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/4 3:46 PM
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
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class KidAnnotationTest {

    @MockK
    lateinit var mother: Mother

    lateinit var kid: Kid

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        kid = Kid(mother)
    }

    @Test
    fun wantMoney() {
        every { mother.giveMoney() } returns 30
        kid.wantMoney()
        assertEquals(30, kid.money)
    }


    @Test
    fun wantMoney1() {
        // When
        val mother = mockk<Mother>()
        val kid = Kid(mother)
        every { mother.giveMoney() } returns 30


        //這是因為在 MockK 裡面，預設情況下 Mock 這個動作是很嚴謹的，你必須要指定所有的行為操作才行，在測試代碼前面加上這行：
        every { mother.inform(any()) } just Runs

        // Given
        kid.wantMoney1()

        // Then
        verify { mother.inform(any()) }
        assertEquals(30, kid.money)
    }


}