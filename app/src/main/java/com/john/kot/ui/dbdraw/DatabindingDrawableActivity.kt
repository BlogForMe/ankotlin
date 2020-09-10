package com.john.kot.ui.dbdraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.util.CustomCountTimer
import com.john.kot.R
import com.john.kot.databinding.ActivityDatabindingDrawableBindingImpl
import kotlinx.android.synthetic.main.activity_databinding_drawable.*

/**
 * 替换shape
 */
class DatabindingDrawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = DataBindingUtil.setContentView<ActivityDatabindingDrawableBindingImpl>(
            this,
            R.layout.activity_databinding_drawable
        )
        tv_count.setOnClickListener {
            CustomCountTimer(6000,1000,bt_resend)
                .apendTxt("s获取").reSendTxt("获取").start()

        }
    }
}