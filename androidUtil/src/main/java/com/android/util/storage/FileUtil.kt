package com.android.util.storage

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.os.Build
import android.util.Base64
import androidx.annotation.RequiresApi
import java.io.BufferedOutputStream
import java.io.Closeable
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

/**
 *
 * ClassName:      FileUtil
 * Description:    Description
 * Author:         zh
 * CreateDate:     12/30/23 19:46
 * UpdateUser:     zh
 * UpdateDate:     12/30/23 19:46
 * UpdateRemark:   Modify the description
 */

object FileUtil {

    fun createFilePath(context: Context, directory: String, file: String): File {
        val contextWrapper = ContextWrapper(context)
        val outputDirectory = contextWrapper.getDir(directory, Context.MODE_PRIVATE)
        return File(outputDirectory, file)
    }

    fun saveImageFile(bitmap: Bitmap, file: File) {
        file.parentFile?.let {
            if (it.exists().not()) {
                it.mkdirs()
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.FROYO)
    fun base64ToFile(file: File, data: String) {
        var bufferedOutputStream: BufferedOutputStream? = null
        try {
            val bitmapArray = Base64.decode(data, Base64.DEFAULT)
            val fileOutputStream = FileOutputStream(file)
            bufferedOutputStream = BufferedOutputStream(fileOutputStream)
            bufferedOutputStream.write(bitmapArray)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            close(bufferedOutputStream)
        }

    }


    fun storeBitmap(bitmap: Bitmap, filePath: String?) {
        val imageFile = File(filePath)
        imageFile.parentFile.mkdirs()
        try {
            val fout: OutputStream = FileOutputStream(imageFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fout)
            fout.flush()
            fout.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


    fun close(close: Closeable?) {
        close?.close()
    }

}