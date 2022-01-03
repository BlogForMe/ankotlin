package com.john.kot.ui.constraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.john.kot.R
import com.john.kot.databinding.ActivityConstraintLayerBinding

class ConstraintLayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConstraintLayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}