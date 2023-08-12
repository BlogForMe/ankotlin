/**
 *
 * ClassName:      MultipleInterfaces
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 10:14 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 10:14 PM
 * UpdateRemark:   Modify the description
 */

package com.kot.mockk.office

import io.mockk.every
import io.mockk.spyk
import org.junit.Test
import java.io.PrintStream

/**
 * Multiple interfaces
    Adding additional behaviours via interfaces and stubbing them:
 */
class MultipleInterfaces {
    @Test
    fun  `Multiple interfaces`(){
        val spy = spyk(System.out, moreInterfaces = *arrayOf(Runnable::class))

        spy.println(555)

        every {
            (spy as Runnable).run()
        } answers {
            (self as PrintStream).println("Run! Run! Run!")
        }

        val thread = Thread(spy as Runnable)
        thread.start()
        thread.join()

    }
}