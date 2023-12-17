package com.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityProgressBarBinding

class ProgressBarActivity : AppCompatActivity() {


    val binding by viewBinding(ActivityProgressBarBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.determinateBar.progress = 66
    }
}