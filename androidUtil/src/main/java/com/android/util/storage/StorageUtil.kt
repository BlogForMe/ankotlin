package com.android.util.storage

import android.content.Context
import android.os.Environment
import android.util.Log
import com.google.gson.Gson
import timber.log.Timber
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by Administrator on 2017/12/14 0014.
 */
object StorageUtil {
    var mCurrentPhotoPath: String? = null

    val isExternalStorageWritable: Boolean
        get() {
            val state = Environment.getExternalStorageState()
            return Environment.MEDIA_MOUNTED == state
        }
    val cacheDirectory: String
        /**
         * 获取应用的缓存目录
         */
        get() {
            val downFile = Environment.getExternalStorageDirectory().path + "/ApkFile"
            if (!File(downFile).exists()) {
                File(downFile).mkdirs()
            }
            if (downFile == null) {
                Timber.w("Can't define system cache directory! The app should be re-installed.")
            }
            return downFile
        }
    val rootDirectory: String?
        get() {
            val downFile = Environment.getExternalStorageDirectory().path
            return downFile
        }

    /**
     * 写出文件
     *
     * @param inputStream
     * @param writeFile
     */
    fun writeSdCard(inputStream: InputStream, writeFile: File?) {
        val fos: FileOutputStream
        val buff = ByteArray(1024)
        try {
            fos = FileOutputStream(writeFile)
            var len: Int
            var sum: Long = 0
            while (inputStream.read(buff).also { len = it } != -1) {
                fos.write(buff, 0, len)
                sum += len.toLong()
            }
            fos.flush()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    var num = 0

    /**
     * 创建oss图片名称
     *
     * @return
     */
    fun createOssImgPath(): String {
        num++
        // Create an image file name
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_" + num
        val imgFile = File(imageFileName, ".jpg")
        // Save a file: path for use with ACTION_VIEW intents
//        mCurrentPhotoPath = image.getAbsolutePath();
        return imgFile.path
    }

    /**
     * 下载的apk命名
     *
     * @param version
     * @return
     */
    fun updateApkName(version: String): String {
        return "tz$version.apk"
    }

    fun getJson(context: Context, fileName: String?): String {
        val stringBuilder = StringBuilder()
        try {
            val assetManager = context.assets
            val bf = BufferedReader(
                InputStreamReader(
                    assetManager.open(
                        fileName!!
                    )
                )
            )
            var line: String?
            while (bf.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return stringBuilder.toString()
    }

    fun <T> jsonToObject(json: String?, type: Type?): T {
        return Gson().fromJson(json, type)
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    fun <T> deepCopy(src: ArrayList<T>?): ArrayList<T> {
        val byteOut = ByteArrayOutputStream()
        val out = ObjectOutputStream(byteOut)
        out.writeObject(src)
        val byteIn =
            ByteArrayInputStream(byteOut.toByteArray())
        val `in` = ObjectInputStream(byteIn)
        return `in`.readObject() as ArrayList<T>
    }

    fun getAppDir(context: Context, appStorageRoot: String, iconDir: String?): String? {
        val sb = StringBuilder()
        if (isExternalStorageWritable) {
            sb.append(getAppExternalStoragePath(appStorageRoot))
        } else {
            sb.append(getCachePath(context))
        }
        sb.append(iconDir)
        sb.append(File.separator)
        val path = sb.toString()
        return if (createDirs(path)) {
            path
        } else null
    }

    //获取SD下当前APP的目录
    private fun getAppExternalStoragePath(appStorageRoot: String): String {
        val sb = StringBuilder()
        sb.append(Environment.getExternalStorageDirectory().absolutePath)
        sb.append(File.separator)
        sb.append(appStorageRoot)
        sb.append(File.separator)
        return sb.toString()
    }

    //创建文件夹
    private fun createDirs(dirPath: String): Boolean {
        val file = File(dirPath)
        return if (!file.exists() || !file.isDirectory) {
            file.mkdirs()
        } else true
    }

    //获取应用的cache目录
    private fun getCachePath(context: Context): String? {
        val f = context.cacheDir
        return if (null == f) {
            null
        } else {
            f.absolutePath + "/"
        }
    }

    fun internalFile(context: Context){
        val file = File(context.filesDir, "internalFile")
        Log.i("StorageUtil", "internalFile: ${file.absolutePath}" )
    }
}