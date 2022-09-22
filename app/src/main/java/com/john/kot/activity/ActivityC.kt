package com.john.kot.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.databinding.ActivityCBinding
import com.john.kot.util.viewBinding

class ActivityC : AppCompatActivity() {
    val biding by viewBinding(ActivityCBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding.btC.setOnClickListener {
            startActivity(Intent(this, ActivityD::class.java))
        }
    }
}