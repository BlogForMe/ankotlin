package com.john.kot

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.util.DateUtil.calculateAge
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DateTest {

    @Test
    fun betweenYear(){
        Assert.assertEquals(10,calculateAge("2010/6/26"))
    }

}