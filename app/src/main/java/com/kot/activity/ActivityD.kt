package com.kot.activity

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.annotation.FloatRange
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityDBinding

class ActivityD : AppCompatActivity() {

    val binding by viewBinding(ActivityDBinding::inflate)

    val TAG = "ActivityD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.tvShow.text = "show"
        val displayMetrics = Resources.getSystem().displayMetrics
        Log.i(TAG, "onCreate: $displayMetrics")
        setLatitude(-360.0)
    }

    fun setLatitude(@FloatRange(from = -90.0, to = 90.0) latitudeDegrees: Double) {
        val mLatitudeDegrees = latitudeDegrees
    }
}

