package com.john.kot.tool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blankj.utilcode.util.LogUtils
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_log.*

class LogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        bt_print.setOnClickListener {
        }

        bt_logUtils.setOnClickListener {
            LogUtils.i("logutils打印")

        }

    }
}
