/**
 *
 * ClassName:      MockNothingTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 10:19 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 10:19 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.john.kot.test.mockk.office.quit
import io.mockk.every
import org.junit.Test

class MockNothingTest {
    @Test
    fun MockNothing(){
        every { quit(1) } throws Exception("this is a test")
    }
}