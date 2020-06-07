package com.john.kot.custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.john.kot.R
import com.john.kot.mvvm.BodyDataModel
import kotlinx.android.synthetic.main.activity_strap_sleep.*

/**
 * 手环的睡眠数据图
 */
class StrapSleepActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strap_sleep)

    }


}
