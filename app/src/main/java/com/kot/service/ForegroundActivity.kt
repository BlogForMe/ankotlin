package com.kot.service

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.android.util.viewbind.viewBinding
import com.kot.R
import com.kot.databinding.ActivityFontBinding
import com.kot.databinding.ActivityForegroundBinding

class ForegroundActivity : AppCompatActivity() {

    val binding by viewBinding(ActivityForegroundBinding::inflate)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btStartService.setOnClickListener {
            startForegroundService(Intent(this, DeviceService::class.java))
        }
    }
}