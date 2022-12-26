/**
 *
 * ClassName:      HierarchicalTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 4:55 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 4:55 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.john.kot.test.mockk.office.AddressBook
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

//Hierarchical mocking
class HierarchicalTest {
    @Test
    fun `Hierarchical mocking`() {
        val addressBook = mockk<AddressBook> {
            every { contacts } returns listOf(
                mockk {
                    every { name } returns "John"
                    every { telephone } returns "123-456-789"
                    every { address.city } returns "New-York"
                    every { address.zip } returns "123-45"
                },
                mockk {
                    every { name } returns "Alex"
                    every { telephone } returns "789-456-123"
                    every { address } returns mockk {
                        every { city } returns "Wroclaw"
                        every { zip } returns "543-21"
                    }
                }
            )
        }
    }
}