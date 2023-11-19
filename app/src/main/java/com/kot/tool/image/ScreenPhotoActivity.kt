package com.kot.tool.image

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.PhotoTakeManger
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityScreenPhotoBinding

/**
 * 上传照片
 */
class ScreenPhotoActivity : AppCompatActivity() {

    private lateinit var photoTakeManger: PhotoTakeManger


    val binding by viewBinding(ActivityScreenPhotoBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoTakeManger = PhotoTakeManger(this)

        binding.tvStartPicker.setOnClickListener {
            photoTakeManger.startTakeByCamera()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        photoTakeManger.attachToActivityForResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}