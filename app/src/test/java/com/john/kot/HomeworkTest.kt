package com.kot

import com.google.common.truth.Truth.assertThat
import com.kot.test.Homework
import org.junit.Test

class HomeworkTest {
    @Test
    fun `fib(0) = 0`() {
//        assertThat(Homework.fib(0)).isEqualTo(0)

//        println("140734477773".length)
//       println("方向"+ "returnsreturnsre".length)
//       println("方向"+ "Enjoyd>2.5%".length)
        println("方向" + "Enjoy>2.5%*".length)
    }

    @Test
    fun `fib(1) = 1`() {
        assertThat(Homework.fib(1)).isEqualTo(1)
    }

    @Test
    fun ff() {
        for (i in 65 until 127) {
            println(i.toChar())
        }
    }

    @Test
    fun `fib(2) = fib(0) + fib(1)`() {
        val fib2 = Homework.fib(2)
        val fib0 = Homework.fib(0)
        val fib1 = Homework.fib(1)
        assertThat(fib0 + fib1).isEqualTo(fib2)
    }

    @Test
    fun `"(a * b))" should return false`() {
        val checkBraces = Homework.checkBraces("(a * b))")
        assertThat(checkBraces).isFalse()
    }

    @Test
    fun `(a * b)" should return true`() {
        val checkBraces = Homework.checkBraces("(a * b)")
        assertThat(checkBraces).isTrue()

        TestCommonState.refrsh

    }


    sealed class CommonState<out T> {
        object Loading : CommonState<Nothing>()
        data class Success<out T>(val data: T) : CommonState<T>()
        data class Failure(val throwable: Throwable) : CommonState<Nothing>()
    }

    class TestCommonState<T> : CommonState<T>() {
        object refrsh : CommonState<Nothing>()
    }


}