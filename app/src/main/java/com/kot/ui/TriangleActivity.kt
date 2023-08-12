package com.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kot.databinding.ActivityTriangleBinding

class TriangleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTriangleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTriangleBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val intArrayView =
//            intArrayOf(binding.view1, binding.view2, binding.view3, binding.view4, binding.view5)
//
//        var  i =0
//        binding.ivTriangle.setOnClickListener {
//             intArrayView[i/5]
//            binding.view3.layoutParams.width = 40
//            binding.view3.isSelected = true
//            binding.view3.requestLayout()
//        }
    }
}