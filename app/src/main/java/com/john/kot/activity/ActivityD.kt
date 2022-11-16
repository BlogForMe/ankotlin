package com.john.kot.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityDBinding
import com.john.kot.util.viewBinding

class ActivityD : AppCompatActivity() {
    val binding by viewBinding(ActivityDBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
    }
}