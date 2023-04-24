package com.android.util

import junit.framework.TestCase.assertFalse
import org.junit.Test


class StringUtilKtTest {

    @Test
    fun validation() {
//        assert("industries".validation("industr(?:y|ies)"))
        assert("12233".validation(REGEX_CHINESE_WITH_INNER_SPACE))
        assert("1234567 23".validation(REGEX_CHINESE_WITH_INNER_SPACE))
        assert("Did g1".validation(REGEX_CHINESE_WITH_INNER_SPACE))
        assertFalse("12233 ".validation(REGEX_CHINESE_WITH_INNER_SPACE))
        assertFalse(" 12233 ".validation(REGEX_CHINESE_WITH_INNER_SPACE))
        assertFalse("1".validation(REGEX_CHINESE_WITH_INNER_SPACE))
        assertFalse("1234567890123456789".validation(REGEX_CHINESE_WITH_INNER_SPACE))

    }
}