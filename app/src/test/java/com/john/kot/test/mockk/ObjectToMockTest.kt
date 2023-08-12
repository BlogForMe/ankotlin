package com.kot.test.mockk

import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class ObjectToMockTest{
    // https://stackoverflow.com/questions/53673292/how-to-call-a-lambda-callback-with-mockk
    @Test
    fun methodToCall(){
        val otm: ObjectToMock = mockk()
        every {  otm.methodToCall(any(), any())} answers {
            secondArg<(String) -> Unit>().invoke("anything")
        }

        otm.methodToCall("bla"){
            println("invoked with $it") //invoked with anything
        }
    }

}