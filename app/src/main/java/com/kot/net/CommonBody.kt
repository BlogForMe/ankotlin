package com.kot.net


/**
 *
 * ClassName:      CommonBody
 * Description:    Description
 * Author:         zh
 * CreateDate:     19/04/2024
 * UpdateUser:     zh
 * UpdateDate:     19/04/2024
 * UpdateRemark:   Modify the description
 */

fun commonToRequestBody(
    commonToRequestBody: String,
): RequestBody {
    return object : RequestBody() {
        override fun writeTo(sink: BufferedSink) {
            sink.write(commonToRequestBody)
        }
    }
}