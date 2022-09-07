package com.john.kot.tool.lbs

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.john.kot.R
import com.john.kot.tool.location.GpsActivity

class GoogleTopUpActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata_stick)
        startActivity(Intent(this, GpsActivity::class.java))
    }

//    onactivityResult(){
//
//    }


}