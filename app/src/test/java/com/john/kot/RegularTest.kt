package com.kot

import com.android.util.printArray
import com.kot.util.SpanStringUtils
import org.junit.Assert
import org.junit.Test
import java.util.regex.Pattern

/**
 *
 * ClassName:      RegularTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/2/7
 * UpdateUser:     zh
 * UpdateDate:     2023/2/7
 * UpdateRemark:   Modify the description
 */

class RegularTest {
    @Test
    fun spaceLine() {
        "earn\r return".split("\\s+".toRegex()).printArray()

        "earn \n  return".split("\\s+".toRegex()).printArray()
        "earn \t  return".split("\\s+".toRegex()).printArray()

        "earn return".split("\\s+".toRegex()).printArray()
        val arrayListOf = arrayListOf("1", "2", "3")
        println(arrayListOf.indexOf("1"))
    }


    @Test
    fun funnyTest() {
//        assert("industries".validation("industr(?:y|ies)"))
        "earn fff\rreturn".split("[\t\n\r]+".toRegex()).printArray()

//        "earn \n  return".split("\\s+".toRegex()).printArray()
//        "earn \t  return".split("\\s+".toRegex()).printArray()
//        "earn return".split("\\s+".toRegex()).printArray()
    }

    @Test
    fun twoLineStrTest() {
        val array = "a b c d ed f g".split("\\s".toRegex())
        val joinToString = array.joinToString(separator = " ", limit = 3, truncated = "")
//        println(joinToString)

        Assert.assertEquals(
            "d ed f g",
            SpanStringUtils.strContactBuffer(3, "a b c d ed f g", "\\s")
        )


    }

    @Test
    fun bankId() {
        val pattern = "^(000202)(010211)(.*?)(0014A0000006150001)(?<bankId>010689003)(.*)"
        val strtext =
            "00020201021126470014A0000006150001010689003802150000100000105195204539953034585802MY5922FNX"
        val compile = Pattern.compile(pattern)
        val matcher = compile.matcher(strtext)
        matcher.find()
        val myNamedGroup = matcher.group("bankId")
        System.out.printf("This is yout named group: %s", myNamedGroup)
    }


    @Test
    fun testId() {

    }

}