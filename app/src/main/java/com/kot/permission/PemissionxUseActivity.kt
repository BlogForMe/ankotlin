package com.kot.permission

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.john.kot.R

/**
 * guolin 库
 */
class PemissionxUseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemissionx_use)
//        bt_start_pemission.setOnClickListener {
//            requestPermissions()
//        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                val denied = ArrayList<String>()
                val deniedAndNeverAskAgain = ArrayList<String>()
                grantResults.forEachIndexed { index, result ->
                    if (result != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                permissions[index]
                            )
                        ) {
                            denied.add(permissions[index])
                        } else {
                            deniedAndNeverAskAgain.add(permissions[index])
                        }
                    }
                }
                if (denied.isEmpty() && deniedAndNeverAskAgain.isEmpty()) {
                    takePicture()
                } else {
                    if (denied.isNotEmpty()) {
                        AlertDialog.Builder(this).apply {
                            setMessage("拍照功能需要您同意相册和定位权限")
                            setCancelable(false)
                            setPositiveButton("确定") { _, _ ->
                                requestPermissions()
                            }
                        }.show()
                    } else {
                        AlertDialog.Builder(this).apply {
                            setMessage("您需要去设置当中同意相册和定位权限")
                            setCancelable(true)
                            setPositiveButton("确定") { _, _ ->
                                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                                val uri = Uri.fromParts("package", packageName, null)
                                intent.data = uri
                                startActivityForResult(intent, 2)
                            }
                        }.show()
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            2 -> {
                requestPermissions()
            }
        }
    }

    fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION), 1
        )
    }

    fun takePicture() {
        Toast.makeText(this, "开始拍照", Toast.LENGTH_SHORT).show()
    }
}