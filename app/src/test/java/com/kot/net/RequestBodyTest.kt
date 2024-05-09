package com.kot.net

import org.junit.Test

import org.junit.Assert.*

class RequestBodyTest {

    @Test
    fun create() {
        val requestBody = RequestBody.create("hello")
        println(requestBody)

        val bufferedSink = BufferedSink()
        requestBody.writeTo(bufferedSink)
    }
}