package com.kot.tool

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityGoogleMapBinding
import java.net.URLEncoder


class GoogleMapActivity : AppCompatActivity() {

    val TAG = "GoogleMapActivity"

    val binding by viewBinding(ActivityGoogleMapBinding::inflate)
    val address =
        URLEncoder.encode("Efc Live Euro-American Plaza, 896 Jingxing Rd, 896, Yuhang District, Hangzhou, Zhejiang, China")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btGoogleMap.setOnClickListener {
            val mUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$address")
            val mIntent = Intent(Intent.ACTION_VIEW, mUri)
            startActivity(mIntent)
//            val toMillis = TimeUnit.SECONDS.toMillis(3000)
//            Log.i(TAG, "onCreate: $toMillis")
        }


        binding.btnWise.setOnClickListener {
            try {
                // Launch Waze to look for Hawaii:
//                val url = "https://waze.com/ul?ll=30.280615,120.003995&navigate=yes"
                val url = "https://waze.com/ul?q=No 4, JALAN SM 1, BANDAR SUNWA"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                // If Waze is not installed, open it in Google Play:
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=com.waze")
//                    Uri.parse("market://details?id=com.google.android.apps.maps")
                )
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.waze"))
                startActivity(intent)
            }
        }

        binding.btBrowserMap.setOnClickListener {
            val uri =
                Uri.parse("http://maps.google.com/maps?daddr=30.280615,120.003995")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        binding.btOfficeMap.setOnClickListener {
            // Display a label at the location of Google's Sydney office
            val gmmIntentUri =
                Uri.parse("geo:0,0?q=30.280615, 120.003995(Google+EFC)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        binding.btTurnByTurn.setOnClickListener {
            val gmmIntentUri =
                Uri.parse("google.navigation:q=30.280615, 120.003995,+Sydney+Australia")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        binding.btGPS.setOnClickListener {
//            LocationUtils.getInstance(this)?.initLocation()

            val enableAdb =
                (Settings.Secure.getInt(getContentResolver(), Settings.Global.ADB_ENABLED, 0) > 0);
            if (enableAdb) {
                Toast.makeText(this, "enable", 1).show();
            } else {
                Toast.makeText(this, "not enable", 1).show();

            }
        }


        binding.checkApp.setOnClickListener {
            val checkInstallation = isPackageInstalled(this, "com.google.android.apps.maps")
            Log.i(TAG, "googleMap: $checkInstallation")
            Log.i(TAG, "youtube: ${isPackageInstalled(this, "com.google.android.youtube")}")
            Log.i(TAG, "gaodemap: ${isPackageInstalled(this, "com.autonavi.minimap")}")
            Log.i(TAG, "baidumap: ${isPackageInstalled(this, "com.baidu.BaiduMap")}")
            Log.i(TAG, "waze: ${isPackageInstalled(this, "com.waze")}")
        }

        binding.checkAppOpen.setOnClickListener {
            //Check if Youtube application is installed
//            var packagename = "com.google.android.apps.maps"
//            var packagename = "com.google.android.youtube"
//            var packagename = "com.autonavi.minimap"
//            val packagename = "com.baidu.BaiduMap"
            var packagename = "com.waze"
            checkPackageInstalled(this, packagename)
        }


        binding.btnIntentAndroid14.setOnClickListener {
            // This makes the intent explicit.
            val explicitIntent =
                Intent("com.activity.action.android14")
            explicitIntent.apply {
                `package` = packageName
            }
            startActivity(explicitIntent)
        }


    }


    fun isPackageInstalled(context: Context, packagename: String): Boolean {
        var result = false
        try {
            // is the application installed?
            context.packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES)
            result = true
        } catch (e: PackageManager.NameNotFoundException) {
            //Not installed
        }
        return result
    }


    fun checkPackageInstalled(context: Context, packagename: String?) {
        try {
            // is the application installed?
            context.packageManager.getPackageInfo(packagename!!, PackageManager.GET_ACTIVITIES)
            //Open app!
            val launchIntent = packageManager.getLaunchIntentForPackage(packagename)
            launchIntent?.let { startActivity(it) }
        } catch (e: PackageManager.NameNotFoundException) {
            Log.i(TAG, "No existe app instalada " + e.message)
            //Not installed, open Play store
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + packagename)
                )
            )
        }
    }

}