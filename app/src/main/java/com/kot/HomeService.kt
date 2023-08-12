/**
 *
 * ClassName:      HomeService
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/12/13 8:25 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/12/13 8:25 PM
 * UpdateRemark:   Modify the description
 */

package com.kot

class HomeService {


    fun sort(defaultList: MutableList<String>) {
        val userSavedFlexiStr = arrayListOf<String>()

        val amcsFlexi = arrayListOf<String>()
        val amcsFixed = arrayListOf<String>()

        val allList = amcsFixed.toMutableList() //Fixed加到头部
        var fixedIndex =amcsFixed.size

        userSavedFlexiStr.forEach {     // 用户flexi的放中间
            if (amcsFlexi.contains(it)) {
                allList.add(fixedIndex,it)
                fixedIndex++
            }else{
                allList.add(it)
            }
        }
        amcsFlexi.forEach {             //AMCS配的 用户没有的
            if (!allList.contains(it)) {
                allList.add(it)
            }
        }

        defaultList.removeAll(allList)
        allList.addAll(defaultList)

    }


}