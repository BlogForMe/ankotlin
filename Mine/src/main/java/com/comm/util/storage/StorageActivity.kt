package com.comm.util.storage

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.util.storage.BitmapUtils
import com.android.util.storage.FileUtil
import com.android.util.storage.StorageUtil
import com.android.util.viewbind.viewBinding
import com.comm.util.R
import com.comm.util.databinding.ActivityStorageBinding
import timber.log.Timber
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date

class StorageActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityStorageBinding::inflate)
    var number = 0
    var fileInnerName = "fileInnerName"
    private var rootFile: String? = null
    private var progressBar: ProgressBar? = null

    private val TAG = "StorageActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootFile = StorageUtil.rootDirectory + "/zhuji.apk"
        progressBar = findViewById(R.id.progress)

        binding.btPrivatefileCrate.setOnClickListener { v: View? ->
            val createFilePath =
                FileUtil.createFilePath(this, "photoImage", "sit/283838388383/avtfjfjf.png")

            createFilePath.parentFile?.takeIf { it.exists().not() }?.mkdirs()

            if (createFilePath.exists().not()) {
                createFilePath.createNewFile()
            }
            Log.i(TAG, "onCreate: $createFilePath")
            FileUtil.base64ToFile(
                createFilePath,
                BitmapUtils.bitmapToBase64(
                    BitmapFactory.decodeResource(
                        resources,
                        R.mipmap.ic_launcher
                    )
                )!!
            )

        }
    }

    private fun createPrivateFile() {
        val fileCache = File(cacheDir, fileInnerName)
        val bf = fileCache.mkdirs()
        Timber.i("createPrivateFile $bf")
    }

    private fun checkPermission() {
        // Here, thisActivity is the current activity
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
            ) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                ) {
                    //                            当某条权限之前已经请求过，并且用户已经拒绝了该权限时，shouldShowRequestPermissionRationale ()方法返回的是true
                } else {
                    //                            ActivityCompat.requestPermissions(getActivity()
                    //                            , new String[]{Manifest.permission
                    //                            .WRITE_EXTERNAL_STORAGE},
                    //                            WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                    requestPermissions(
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        WRITE_EXTERNAL_STORAGE_REQUEST_CODE
                    )
                }
            }
        } else {
            createExternalStorage()
        }
    }

    fun btPermission(v: View?) {
        checkPermission()
    }

    fun btCreateFile(v: View?) {
        createExternalStorage()
    }

    /**
     * 生成时间戳文件
     *
     * @param view
     */
    fun btFile(view: View?) {
        try {
            createImageFile()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            WRITE_EXTERNAL_STORAGE_REQUEST_CODE -> {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }
        }
    }

    private fun createExternalStorage() {
        val dir = StorageUtil.cacheDirectory
        val apkDIR = "apkdir.apk"
        val apkFile = File(dir, apkDIR)
        if (!StorageUtil.isExternalStorageWritable) {
            return
        }
        if (apkFile.exists()) {  //如果存在则删除文件
            apkFile.delete()
        }
        var isCreate = false
        try {
            isCreate = apkFile.createNewFile()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        if (isCreate) {
            readApk(rootFile, apkFile.path)
        }
    }

    private fun readApk(rootFile: String?, apkFile: String) {
        val buff = ByteArray(1024)
        try {
            val `is` = FileInputStream(rootFile)
            val fos = FileOutputStream(apkFile)
            var len: Int
            var sum = 0
            while (`is`.read(buff).also { len = it } != -1) {
                fos.write(buff, 0, len)
                sum += len
                val progress = (sum * 1.0f / sum * 100).toInt()
                progressBar!!.progress = progress
            }
            fos.flush()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        number++
        // Create an image file name
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_" + number
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            imageFileName,
            ".jpg",
            storageDir
        )
        // Save a file: path for use with ACTION_VIEW intents
        val mCurrentPhotoPath = image.absolutePath
        return image
    }

    companion object {
        private const val WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1
    }
}