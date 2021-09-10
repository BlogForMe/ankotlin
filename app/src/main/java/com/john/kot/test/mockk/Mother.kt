/**
 *
 * ClassName:      Mother
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/4 3:35 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/4 3:35 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.test.mockk

class Mother {
    fun inform(money: Int) {
        println("媽媽我現在有 $money 元，我要跟你拿錢！")
    }

    fun giveMoney(): Int {
        return 100
    }
}