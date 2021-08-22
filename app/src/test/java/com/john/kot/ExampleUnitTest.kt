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

        for (i in 1..3) {
            println(i)
        }
    }


    @Test
    fun formatOne() {
        val df = DecimalFormat("#0.0")

        assertEquals(34.3f, df.format(34.34f))
    }

    @Test
    fun strapTest() {
        val data: String =
            "333333333333222222222222222222222323233333332222222233232232222223333333"
//        var listIterator = data.toList()

//        var dataList = listOf<String>(data)
//        dataList.forEach { item ->
//            print("$item" + " ")
//        }

//        val listIterator = dataList.listIterator()
//        while (listIterator.hasNext()) listIterator.next()
//        println("Iterating backwards:")
//        while (listIterator.hasPrevious()) {
//            println("Index: ${listIterator.previousIndex()}")
//            println(", value: ${listIterator.previous()}")
//        }
//        for ((index,value) in data.withIndex()){
//            println("$index: $value")
//        }

//        println("333333333333222222222222222222222323233333332222222233232232222223333333".length)
        val dark = 2
        println(data.toCharArray().filter { ch -> ch == dark.toChar() }.count())
    }


}
