package com.john.kot

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.john.kot", appContext.packageName)
    }


//    @get:Rule
//    val activityRule = ActivityTestRule(MainActivity::class.java)
//
//    @Test fun listGoesOverTheFold() {
//        onView(withText("Hello world!")).check(matches(isDisplayed()))
//    }


    @Test
    fun nullOrEmpty() {
//        val data = " " // this is a text with blank space
//        println(data.isNullOrBlank()?.toString())  //true
//        println(data.isNullOrEmpty()?.toString())  //false

        val dataValue1: String? = null
        val dataValue2: String? = " "
        assertEquals(true, dataValue1.isNullOrBlank())
        assertEquals(true, dataValue1.isNullOrEmpty())

        assertEquals(true, dataValue2.isNullOrBlank())
        assertEquals(true, dataValue2.isNullOrEmpty())


    }


}
