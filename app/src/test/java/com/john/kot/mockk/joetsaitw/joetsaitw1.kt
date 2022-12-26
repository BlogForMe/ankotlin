/**
 *
 * ClassName:      joetsaitw1
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/4 3:36 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/4 3:36 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk

import com.john.kot.test.mockk.Kid
import com.john.kot.test.mockk.Mother
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import org.junit.Test
//https://medium.com/joe-tsai/mockk-%E4%B8%80%E6%AC%BE%E5%BC%B7%E5%A4%A7%E7%9A%84-kotlin-mocking-library-part-2-4-4be059331110

class joesaintw{
    @Test
    fun wantMoney() {
        // Given
        val mother = mockk<Mother>()
        val kid = Kid(mother)
        every { mother.giveMoney() } returns 30 // when().thenReturn() in Mockito

        // When
        kid.wantMoney()
        // Then
        assertEquals(30, kid.money)
    }
}