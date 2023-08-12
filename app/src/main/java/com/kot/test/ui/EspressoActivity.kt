package com.kot.test.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kot.databinding.ActivityEspressoBinding

class EspressoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEspressoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvEnable.setOnClickListener {

        }
    }
}