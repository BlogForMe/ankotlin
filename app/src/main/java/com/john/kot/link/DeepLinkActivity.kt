package com.john.kot.link

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.databinding.ActivityDeepLinkBinding

class DeepLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityDeepLinkBinding.inflate(layoutInflater)
        setContentView(biding.root)
    }
}