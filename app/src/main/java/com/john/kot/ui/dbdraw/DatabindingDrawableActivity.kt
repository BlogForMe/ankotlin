package com.john.kot.ui.dbdraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.john.kot.R
import com.john.kot.databinding.ActivityDatabindingDrawableBindingImpl

class DatabindingDrawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = DataBindingUtil.setContentView<ActivityDatabindingDrawableBindingImpl>(
            this,
            R.layout.activity_databinding_drawable
        )
    }
}