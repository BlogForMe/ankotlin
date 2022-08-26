package com.john.kot.util

import android.content.Context
import android.graphics.Color
import android.text.SpannableString
import android.text.TextUtils

/**
 *
 * ClassName:      Language
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/8/17 1:26 PM
 * UpdateUser:     zh
 * UpdateDate:     2022/8/17 1:26 PM
 * UpdateRemark:   Modify the description
 */

object LanguageUtil {

    fun setLanguageSpanString(
        context: Context, origin: String, listener: SpanStringUtils.Listener? = null
    ): SpannableString {
        if (TextUtils.isEmpty(origin)) {
            return SpannableString("")
        }
        val list = origin.split("$$$")
        val text = list[0]
        var spannableString = SpannableString(text)
        try {
            val placeList = list.subList(1, list.size)
            for (s in placeList) {
                val subList = s.split(":::")
                val split = subList[0].split(",")
                spannableString = setSpan(
                    context, text, subList, split, spannableString, listener
                )
            }
            return spannableString

        } catch (e: java.lang.Exception) {
        }
        return SpannableString(text)
    }

    private fun setSpan(
        context: Context, text: String,
        subList: List<String>, split: List<String>,
        spannableString: SpannableString, listener: SpanStringUtils.Listener? = null
    ): SpannableString {
        var span = spannableString
        val index = Integer.parseInt(split[0])
        val changedText = text.substring(index, index + Integer.parseInt(split[1]))
        if (subList.size >= 2 && (listener != null)) {
            if (subList[1].isNotEmpty()) {
                listener.url = subList[1]
            }
            span = SpanStringUtils.setClickable(context, span, changedText, listener)
        }
        if (subList.size >= 3 && !TextUtils.isEmpty(subList[2])) {
            span = SpanStringUtils.setTextColor(
                span, changedText, Color.parseColor(subList[2])
            )
        }
        if (subList.size >= 4 && "1" == subList[3]) {
            span = SpanStringUtils.setTextBold(span, changedText)
        }
        if (subList.size >= 5 && !TextUtils.isEmpty(subList[4]) && "1" == subList[4]) {
            span =
                SpanStringUtils.setTextUnderLine(span, changedText)
        }
        return span
    }
}