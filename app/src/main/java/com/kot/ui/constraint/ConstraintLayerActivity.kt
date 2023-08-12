package com.kot.ui.constraint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kot.databinding.ActivityConstraintLayerBinding

class ConstraintLayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConstraintLayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}