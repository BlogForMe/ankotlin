package com.john.kot.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityConstraintBinding
import kotlinx.android.synthetic.main.activity_constraint.*

class ConstraintPlaceholderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstraintBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btOne.setOnClickListener {
            group1.visibility = View.VISIBLE
        }

        binding.btTwo.setOnClickListener {
            group2.visibility = View.INVISIBLE
        }

        binding.ivGirl1.setOnClickListener {
            binding.placeHolder.setContentId(R.id.iv_girl1)
        }

    }
}
