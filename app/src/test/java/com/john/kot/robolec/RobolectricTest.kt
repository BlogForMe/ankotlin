package com.john.kot.robolec

import android.util.ArrayMap
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 *
 * ClassName:      RobolectricTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/10/8 3:15 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/10/8 3:15 PM
 * UpdateRemark:   Modify the description
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class RobolectricTest {
    @Test
    fun arrayMapTest() {
        val arrayMap = ArrayMap<Int, Int>()
        for (i in 0 until 4) {
            arrayMap.put(i, i)
        }
        arrayMap[4] = 4
    }
}