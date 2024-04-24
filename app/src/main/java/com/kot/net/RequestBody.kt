package com.kot.net


/**
 *
 * ClassName:      RequestBody
 * Description:    Description
 * Author:         zh
 * CreateDate:     19/04/2024
 * UpdateUser:     zh
 * UpdateDate:     19/04/2024
 * UpdateRemark:   Modify the description
 */

abstract class RequestBody {
    abstract fun writeTo(sink: BufferedSink)


    companion object {
        /**
         * Returns a new request body that transmits this string. If [contentType] is non-null and lacks
         * a charset, this will use UTF-8.
         */
        @JvmStatic
        @JvmName("create")
        fun String.toRequestBody(string: String): RequestBody {
            return commonToRequestBody(string)
        }

        fun create(
            content: String,
        ): RequestBody = content.toRequestBody(content)
    }
}
