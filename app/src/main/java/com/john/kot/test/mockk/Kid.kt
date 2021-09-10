/**
 *
 * ClassName:      Kid
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/4 3:32 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/4 3:32 PM
 * UpdateRemark:   Modify the description
 */

package com.john.kot.test.mockk

class Kid(private val mother: Mother) {
    var money = 10
        private set

    fun wantMoney() {
        money += mother.giveMoney()
    }


    fun wantMoney1() {
        mother.inform(money)
        money += mother.giveMoney()
    }
}