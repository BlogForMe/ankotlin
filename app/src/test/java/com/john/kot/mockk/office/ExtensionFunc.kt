/**
 *
 * ClassName:      ExtentionFunc
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 9:14 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 9:14 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.mockk.office

import com.john.kot.test.mockk.office.Ext
import com.john.kot.test.mockk.office.Obj
import com.john.kot.test.mockk.office.extensionFunc
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class ExtensionFunc {
    @Test
    fun ExtensionFunc(){

        with(mockk<Ext>()) {
            every {
                Obj(5).extensionFunc()
            } returns 11

            assertEquals(11, Obj(5).extensionFunc())

            verify {
                Obj(5).extensionFunc()
            }
        }
    }

    //mock 静态拓展方法
    @Test
    fun `mockkStatic extension func`(){

        mockkStatic("com.john.kot.test.mockk.office.Obj.kt")

        every {
            Obj(5).extensionFunc()
        } returns 11

        assertEquals(11, Obj(5).extensionFunc())

        verify {
            Obj(5).extensionFunc()
        }
    }

    @Test
    fun `mockkStatic with the module’s class name as an argument`(){
        fun Obj.extensionFunc() = value + 5


//        mockkStatic("com.john.kot.test.mockk.office.Obj.kt")
     //或者
        mockkStatic(Obj::extensionFunc)

        every {
            Obj(5).extensionFunc()
        } returns 11

        assertEquals(11, Obj(5).extensionFunc())

        verify {
            Obj(5).extensionFunc()
        }
    }
}