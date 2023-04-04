package com.john.kot.ui.constraint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.databinding.ActivityConstraint1Binding

class Constraint1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityConstraint1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraint1Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.view1.isSelected = true
    }
}
