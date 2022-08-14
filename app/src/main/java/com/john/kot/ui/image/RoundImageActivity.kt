package com.john.kot.ui.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.kot.R
import com.john.kot.databinding.ActivityRoundImageBinding

class RoundImageActivity : AppCompatActivity() {
    val biding by lazy { ActivityRoundImageBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
    }
}