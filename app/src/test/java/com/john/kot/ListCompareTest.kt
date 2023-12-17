package com.kot

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.collection.IsEmptyCollection
import org.hamcrest.collection.IsIterableContainingInAnyOrder
import org.junit.Test

/**
 *  http://hamcrest.org/JavaHamcrest/distributables
 *
 */
class ListCompareTest {
    //https://stackoverflow.com/questions/46788032/compare-2-liststring-if-they-contain-same-elements-in-any-order-junit-asset
    //https://mkyong.com/unittest/junit-how-to-test-a-list/
    @Test
    fun `compare to list`() {
//        val expected:List<String> = listOf("StringA", "String b")
//        val actual:List<String> = listOf("StringA", "String b")

        val actual = listOf("a", "b", "c")
        val expected = listOf("a", "b", "c")

        //All passed / true

        //1. Test equal.

        //All passed / true

        //1. Test equal.
        assertThat(actual, CoreMatchers.`is`(expected))

        //2. If List has this value?

        //2. If List has this value?
        assertThat(actual, CoreMatchers.hasItems("b"))

        //3. Check List Size

        //3. Check List Size
        assertThat(actual, Matchers.hasSize(3))

        assertThat(actual.size, CoreMatchers.`is`(3))

        //4.  List order

        // Ensure Correct order

        //4.  List order

        // Ensure Correct order
        assertThat(actual, Matchers.contains("a", "b", "c"))

        // Can be any order

        // Can be any order
        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder("c", "b", "a"))

        //5. check empty list

        //5. check empty list
        assertThat(actual, CoreMatchers.not(IsEmptyCollection.empty()))

//        assertThat(ArrayList(), IsEmptyCollection.empty())

    }


    @Test
    fun testdd() {
        val ddd: Any? = null

        println(ddd.toString())

    }
}