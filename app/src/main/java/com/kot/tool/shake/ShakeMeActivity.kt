package com.kot.tool.shake

import android.Manifest.permission.HIGH_SAMPLING_RATE_SENSORS
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityShakeMeBinding

class ShakeMeActivity : AppCompatActivity(), SensorShake.Listener {
    val binding by viewBinding(ActivityShakeMeBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sd = SensorShake(this)


        binding.btStart.setOnClickListener {
            sd.start(sensorManager)
        }

        binding.btStop.setOnClickListener {
            sd.stop()
        }
        binding.btPermission.setOnClickListener {
            val permission = ContextCompat.checkSelfPermission(
                this,
                HIGH_SAMPLING_RATE_SENSORS
            )
            Log.i("ShakeMeActivity", "onCreate: $permission")
        }
    }

    override fun hearShake() {
        Toast.makeText(this, "Don't shake me, bro!", Toast.LENGTH_SHORT).show()
    }
}