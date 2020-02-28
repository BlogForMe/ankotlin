package com.john.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import kotlinx.android.synthetic.main.ble_activity_temp.*

class CircleProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ble_activity_temp)
//        setContentView(R.layout.activity_circle_progress)


//        tv_confirm.setOnClickListener {
//            Timber.i("degree    "+trm_rule.getDegree())
//        }

        var degree= 34.0f
        val scaleUnit =0.1f
        bt_add.setOnClickListener {
//            degree+=scaleUnit
//            trm_rule.setDegree(degree.toString())
        }
    }
}
