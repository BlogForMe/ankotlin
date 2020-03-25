package com.john.kot.tool.location

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.util.LocationUtil
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_location.*

class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        bt_location.setOnClickListener {
            LocationUtil.getInstance(this).getLastLocation()
        }
    }
}
