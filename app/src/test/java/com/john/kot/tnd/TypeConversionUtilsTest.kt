package com.john.kot.tnd


import com.john.kot.test.TypeConversionUtils.stringToInt
import org.junit.Before
import org.junit.Test

class TypeConversionUtilsTest {

    @Before
    fun setUp() {
    }


    @Test
    fun `stringToIntTest`() {
        assert(stringToInt(null) == 0)
        assert(stringToInt("", 1) == 1)
        assert(stringToInt("test", 1) == 1)
        assert(stringToInt("10", 1) == 10)
    }

}