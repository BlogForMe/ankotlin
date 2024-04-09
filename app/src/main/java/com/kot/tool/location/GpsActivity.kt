package com.kot.tool.location

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.util.LocationUtils
import com.android.util.viewbind.viewBinding
import com.kot.R
import com.kot.compose.ComposeDialogFragment
import com.kot.databinding.ActivityLocationBinding
import com.kot.ui.BottomSheetReview

class GpsActivity : AppCompatActivity() {
    val binding by viewBinding(ActivityLocationBinding::inflate)


    private val REQUEST_LOCATION_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLocation.setOnClickListener {
            requestLocationPermission()
        }
        binding.btNetwork.setOnClickListener {

        }
        binding.btGps.setOnClickListener {
            openGpsPage()
        }
        binding.btPermission.setOnClickListener {
            settingPermissionPage()
        }

        binding.btBottomSheet.setOnClickListener {
            ComposeDialogFragment().show(this.supportFragmentManager, null)
        }
        binding.btBottomDialog.setOnClickListener {
            BottomSheetReview().show(supportFragmentManager, null)
        }
    }

    private fun getLocation() {
        val locationByNetwork = LocationUtils.getInstance(this).locationByNetwork
        if (locationByNetwork != null) {
            Log.i(
                "GpsActivity",
                "onCreate:   地理位置：lon:${locationByNetwork.longitude};lat:${locationByNetwork.latitude}"
            )
        }
    }

    fun requestLocationPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
                showLocationWithToast()
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) -> {
                // In an educational UI, explain to the user why your app requires this
                // permission for a specific feature to behave as expected, and what
                // features are disabled if it's declined. In this UI, include a
                // "cancel" or "no thanks" button that lets the user continue
                // using your app without granting the permission.
//                showInContextUI(...)
                Toast.makeText(this, "go setting", Toast.LENGTH_SHORT).show()
            }

            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher.launch(
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            }
        }
    }


    // Register the permissions callback, which handles the user's response to the
// system permissions dialog. Save the return value, an instance of
// ActivityResultLauncher. You can use either a val, as shown in this snippet,
// or a lateinit var in your onAttach() or onCreate() method.
    val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your
                // app.
                showLocationWithToast()
            } else {
                // Explain to the user that the feature is unavailable because the
                // feature requires a permission that the user has denied. At the
                // same time, respect the user's decision. Don't link to system
                // settings in an effort to convince the user to change their
                // decision.
                Toast.makeText(
                    this,
                    "permission denied ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    private fun showLocationWithToast() {
        val location = LocationUtils.getInstance(this).location
        location?.let {
            Toast.makeText(
                this,
                "地理位置：lon:${it.longitude};lat:${it.latitude}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    /**
     * 检查地理位置开关是否打开，如果未打开，则提示用户打开地理位置开关。
     * 如果已打开，则显示地理位置；如果被拒绝，直接关闭窗口。
     */
    private fun requestLocation() {
        val message = "本应用需要获取地理位置，请打开获取位置的开关"
        val alertDialog = AlertDialog.Builder(this).setMessage(message).setCancelable(false)
            .setPositiveButton(android.R.string.ok)
            { dialog, _ ->
                dialog.dismiss()
                gotoSysLocationSettingsPage()
            }
            .setNegativeButton(android.R.string.cancel) { dialog, _ -> dialog.dismiss() }
            .create()
        alertDialog.show()
    }

    private fun gotoSysLocationSettingsPage() {
        val intent = Intent()
        intent.action = Settings.ACTION_LOCATION_SOURCE_SETTINGS
        startActivityForResult(intent, REQUEST_LOCATION_PERMISSION_CODE)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (requestCode) {
//            REQUEST_LOCATION_PERMISSION_CODE -> showLocation()
//            else -> {
//            }
//        }
//    }

    fun openGpsPage() {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes") { _, _ ->
                    startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                }
                .setNegativeButton("No") { dialog, _ -> dialog.cancel() }
            val alert = builder.create()
            alert.show()
        }
    }

    fun settingPermissionPage() {
        val intent = Intent().apply {
            action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            addCategory(Intent.CATEGORY_DEFAULT)
            data = Uri.parse("package:" + this@GpsActivity.packageName)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            flags = Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


}
