package com.john.kot.test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.john.kot.R
import com.john.kot.databinding.ActivityEspressoBinding

class EspressoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityEspressoBinding.inflate(layoutInflater)
        setContentView(biding.root)
        biding.tvEnable.setOnClickListener {

        }
    }
}