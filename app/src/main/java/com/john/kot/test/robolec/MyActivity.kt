package com.john.kot.test.robolec

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        findViewById<Button>(R.id.press_me_button).setOnClickListener {
            findViewById<TextView>(R.id.results_text_view).setText("Testing Android Rocks!")
        }
    }

    fun launchDeepLinkWithWhiteList(
        activity: Activity?,
        deepLink: String,
        delayMillis: Long
    ) {
        fun doLaunch() {

        }
    }

}