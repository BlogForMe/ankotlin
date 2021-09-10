/**
 *
 * ClassName:      MockingNothing
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 10:18 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 10:18 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.test.mockk.office

import kotlin.system.exitProcess

fun quit(status: Int): Nothing {
    exitProcess(status)
}
