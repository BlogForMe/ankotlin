package com.kot.link

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kot.databinding.ActivityDeepLinkBinding

class DeepLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeepLinkBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}