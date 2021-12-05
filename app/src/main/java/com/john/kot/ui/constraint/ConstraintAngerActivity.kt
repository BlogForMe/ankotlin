package com.john.kot.ui.constraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.kot.R
import com.john.kot.databinding.ActivityConstraintConerBinding

class ConstraintAngerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityConstraintConerBinding.inflate(layoutInflater)
        setContentView(biding.root)
    }
}