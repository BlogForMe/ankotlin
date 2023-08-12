package com.kot.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityCBinding

class ActivityC : AppCompatActivity() {

    //    val bddd: ActivityCBinding = ActivityCBinding.inflate(layoutInflater)
    val binding by viewBinding(ActivityCBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ss: (LayoutInflater, ViewGroup?, Boolean) -> ViewBinding = ActivityCBinding::inflate
//        val binding = ActivityCBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        binding.btC.setOnClickListener {
            startActivity(Intent(this, ActivityD::class.java))
        }
    }
}

class ABinding {
    fun inflate() {

    }
}