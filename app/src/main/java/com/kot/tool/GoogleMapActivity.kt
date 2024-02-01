package com.kot.tool

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityGoogleMapBinding
import com.kot.tool.location.LocationUtils
import java.util.concurrent.TimeUnit


class GoogleMapActivity : AppCompatActivity() {

    val TAG = "GoogleMapActivity"

    val binding by viewBinding(ActivityGoogleMapBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btMap.setOnClickListener {

//geo:latitude,longitude
//geo:latitude,longitude?z=zoom，z表示zoom级别，值为数字1到23
//geo:0,0?q=my+street+address
//geo:0,0?q=business+near+city

//geo:latitude,longitude
//geo:latitude,longitude?z=zoom，z表示zoom级别，值为数字1到23
//geo:0,0?q=my+street+address
//geo:0,0?q=business+near+city
//            val mUri = Uri.parse("geo:30.280615, 120.003995?q=EFC")
//            val mIntent = Intent(Intent.ACTION_VIEW, mUri)
//            startActivity(mIntent)
            val toMillis = TimeUnit.SECONDS.toMillis(3000)
            Log.i(TAG, "onCreate: $toMillis")
        }




        binding.btAnotherMap.setOnClickListener {
            val uri =
                Uri.parse("http://maps.google.com/maps?saddr=30.280615,120.003995")
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
    }
}