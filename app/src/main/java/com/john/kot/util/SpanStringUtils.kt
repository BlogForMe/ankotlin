package com.john.kot.util

import android.content.Context
import android.graphics.Typeface
import android.text.*
import android.text.style.*
import android.util.Log
import android.view.View
import com.john.kot.R
import com.john.kot.anim.TextViewBigActivity
import java.lang.StringBuilder
import java.util.regex.Pattern

/**
 * Created by Administrator on 2018/5/14.
 */

object SpanStringUtils {

    fun strContactBuffer(index: Int, str: String, pattern: String): String {
        val strBuilder = StringBuilder()
        val array = str.split(pattern.toRegex())
        for (i in index until array.size) {
            val append = strBuilder.append(array[i])
            if (i != array.lastIndex) {
                append.append(" ")
            }
        }
        return strBuilder.toString()
    }

    fun contactIndexBuffer(index: Int, array: List<String>): String {
        val strBuilder = StringBuilder()
        for (i in index until array.size) {
            val append = strBuilder.append(array[i])
            if (i != array.lastIndex) {
                append.append(" ")
            }
        }
        return strBuilder.toString()
    }

    fun setClickable(
        context: Context,
        text: String,
        changedText: String,
        listener: Listener
    ): SpannableString {
        val spanText = SpannableString(text)
        return setClickable(context, spanText, changedText, listener)
    }

    fun setClickable(
        context: Context, spanText: SpannableString,
        changedText: String, listener: Listener
    ): SpannableString {

        val color = context.resources.getColor(R.color.bgGreenColor)

        setSpan(spanText, changedText, object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = color
                ds.isUnderlineText = false
            }

            override fun onClick(view: View) {
                view.cancelPendingInputEvents() // Prevent view state from being toggled when link is clicked
                listener.onSpanClick(view)
            }
        })
        return spanText
    }

    fun <S : CharacterStyle> setSpan(spanText: SpannableString, text: String, what: S) {
        val start = spanText.toString().toLowerCase().indexOf(text.toLowerCase())
        val end = start + text.length
        if (start != -1) {
            spanText.setSpan(what, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    /**
     * 设置文字加粗
     *
     * @param text  文本
     * @param changedText 加粗的文本
     * @param
     * @return
     */
    fun setTextBold(text: String, changedText: String): SpannableString {
        if (TextUtils.isEmpty(text)) {
            return SpannableString("")
        }
        val span = SpannableString(text)
        try {
            val index = text.indexOf(changedText)
            if (index != -1) {
                span.setSpan(
                    StyleSpan(Typeface.BOLD), index, index + changedText.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        } catch (e: Exception) {

        }

        return span
    }

    /**
     * 设置文字颜色
     *
     * @param text        文本
     * @param changedText 需要修改颜色的文本
     * @param color       颜色
     * @return 修改完成的文本
     */
    fun setTextColor(text: String, changedText: String, color: Int): SpannableString {
        if (TextUtils.isEmpty(text)) {
            return SpannableString("")
        }
        val span = SpannableString(text)
        try {
            val index = text.indexOf(changedText)
            if (index != -1) {
                span.setSpan(
                    ForegroundColorSpan(color), index,
                    index + changedText.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }

        } catch (e: Exception) {

        }

        return span
    }

    fun setTextColor(span: SpannableString, changedText: String, color: Int): SpannableString {
        if (span == null) {
            return SpannableString("")
        }

        try {
            val index = span.toString().indexOf(changedText)
            if (index != -1) {
                span.setSpan(
                    ForegroundColorSpan(color), index,
                    index + changedText.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }

        } catch (e: Exception) {

        }

        return span
    }

    fun setTextBold(span: SpannableString, changedText: String): SpannableString {

        if (span == null) {
            return SpannableString("")
        }

        try {
            val index = span.toString().indexOf(changedText)
            if (index != -1) {
                span.setSpan(
                    StyleSpan(Typeface.BOLD), index, index + changedText.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        } catch (e: Exception) {

        }


        return span
    }

    fun setTextUnderLine(text: String, changedText: String): SpannableString {
        if (TextUtils.isEmpty(text)) {
            return SpannableString("")
        }
        val span = SpannableString(text)
        try {
            val index = text.indexOf(changedText)
            if (index != -1) {
                span.setSpan(
                    UnderlineSpan(), index, index + changedText.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        } catch (e: Exception) {

        }


        return span
    }

    fun setTextUnderLine(span: SpannableString, changedText: String): SpannableString {
        if (span == null) {
            return SpannableString("")
        }

        try {
            val index = span.toString().indexOf(changedText)
            if (index != -1) {
                span.setSpan(
                    UnderlineSpan(), index, index + changedText.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        } catch (e: Exception) {

        }
        return span
    }

    /**
     * url不传的话，会自动从多语言中获取。
     */
    abstract class Listener(var url: String? = null) {
        abstract fun onSpanClick(view: View)
    }
}
