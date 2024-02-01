package com.android.util.storage

import android.graphics.Bitmap
import android.os.Build
import android.util.Base64
import androidx.annotation.RequiresApi
import java.io.ByteArrayOutputStream

/**
 *
 * ClassName:      BitmapUtil
 * Description:    Description
 * Author:         zh
 * CreateDate:     12/30/23 22:23
 * UpdateUser:     zh
 * UpdateDate:     12/30/23 22:23
 * UpdateRemark:   Modify the description
 */

object BitmapUtils {
    @RequiresApi(Build.VERSION_CODES.FROYO)
    fun bitmapToBase64(bitmap: Bitmap): String? {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        outputStream.flush()
        outputStream.close()
        val toByteArray = outputStream.toByteArray()
        return Base64.encodeToString(toByteArray, Base64.NO_WRAP)
    }
}