package com.john.kot.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import kotlinx.android.synthetic.main.ble_activity_temp.*
import timber.log.Timber

class CircleProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ble_activity_temp)
//        setContentView(R.layout.activity_circle_progress)


//        tv_confirm.setOnClickListener {
//            Timber.i("degree    "+trm_rule.getDegree())
//        }
    }
}
