package com.john.kot

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

//    @Rule
//    @JvmField
//    val rule = ActivityTestRule(TestActivity::class.java)


    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.john.kot", appContext.packageName)

    }


//
//
//
//
//
//    @Test
//    fun user_can_enter_first_name(){
////        onView(withId(R.id.firstName)).perform(typeText("Daniel"))
//    }
//
//
//    @Test
//    fun user_can_enter_last_name(){
//        onView(withId(R.id.lastName)).perform(typeText("Malone"))
//    }
//
//
//    @Test
//    fun when_user_enters_first_and_last_name_check_to_confirm_that_message_is_correct(){
//        onView(withId(R.id.firstName)).perform(typeText("Jake"))
//        onView(withId(R.id.lastName)).perform(typeText("Smith"))
//        onView(withId(R.id.button)).perform(click())
//        onView(withId(R.id.message)).check(matches(withText("Welcome,Jake Smith")))
//    }


//
//    @Test fun listGoesOverTheFold() {
//        onView(withText("Hello world!")).check(matches(isDisplayed()))
//    }


//    @Test
//    fun nullOrEmpty() {
//        val data = " " // this is a text with blank space
//        println(data.isNullOrBlank()?.toString())  //true
//        println(data.isNullOrEmpty()?.toString())  //false

//        val dataValue1: String? = null
//        val dataValue2: String? = " "
//        assertEquals(true, dataValue1.isNullOrBlank())
//        assertEquals(true, dataValue1.isNullOrEmpty())
//
//        assertEquals(true, dataValue2.isNullOrBlank())
//        assertEquals(true, dataValue2.isNullOrEmpty())
//    }




}
