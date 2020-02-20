package com.john.kot

import org.junit.Test

import org.junit.Assert.*
import java.text.DecimalFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)

        for(i in 1..3){
            println(i)
        }
    }


    @Test
    fun formatOne(){
        val df = DecimalFormat("#0.0")

        assertEquals(34.3f,df.format(34.34f))
    }
}
