package com.kot

import org.junit.Test

/**
 *
 * ClassName:      MultipleLanguage
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/4
 * UpdateUser:     zh
 * UpdateDate:     2023/4/4
 * UpdateRemark:   Modify the description
 */

class MultipleLanguageTest {
    @Test
    fun rangeTest() {
        val rangTxt =
            "Need help on setting up a strong PIN for your eWallet? Here are some tips \$\$\$55,18::::::#0064FF:::0:::0"
        println(rangTxt[55])
    }
}