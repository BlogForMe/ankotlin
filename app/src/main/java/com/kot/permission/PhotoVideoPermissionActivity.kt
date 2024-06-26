package com.kot.permission

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.Manifest.permission.READ_MEDIA_VIDEO
import android.Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityPhotoVideoPermissionBinding

/**
 *  https://developer.android.com/about/versions/14/changes/partial-photo-video-access
 *
 *  https://seeratabbaskhan.medium.com/custom-progress-bar-in-android-with-background-99de450af168
 */
class PhotoVideoPermissionActivity : AppCompatActivity() {
    val TAG = "PhotoVideoPermission"
    val binding by viewBinding(ActivityPhotoVideoPermissionBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btRequestTarget34.setOnClickListener {
            // Permission request logic
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                requestPermissions.launch(
                    arrayOf(
                        READ_MEDIA_IMAGES,
                        READ_MEDIA_VIDEO,
//                        READ_MEDIA_VISUAL_USER_SELECTED
                    )
                )
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requestPermissions.launch(arrayOf(READ_MEDIA_IMAGES, READ_MEDIA_VIDEO))
            } else {
                requestPermissions.launch(arrayOf(READ_EXTERNAL_STORAGE))
            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    // Register ActivityResult handler
    val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
            // Handle permission requests results
            // See the permission example in the Android platform samples: https://github.com/android/platform-samples
            Log.i(TAG, ": $results")

            isPermissionGranted(READ_MEDIA_IMAGES)

            val permission1 = results[READ_MEDIA_IMAGES]
            val permission2 = results[READ_MEDIA_VIDEO]

            Log.i(TAG, ": $permission1   $permission2")


        }

    private fun isPermissionGranted(name: String) = ContextCompat.checkSelfPermission(
        this, name
    ) == PackageManager.PERMISSION_GRANTED

}