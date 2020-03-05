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

        val scaleUnit =0.1f
//        bt_add.setOnClickListener {
//        }
    }

    override fun onStart() {
        super.onStart()


    }

    override fun onResume() {
        super.onResume()
        var degree= "37.0"
        trm_rule.setDegree(degree)
    }
}
