package com.john.kot.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.kot.R
import com.john.kot.databinding.ActivityLiveData02Binding
import com.john.kot.util.viewBinding

class KeyBordActivity : AppCompatActivity() {

//    val binding by viewBinding(activity::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_bord)
    }
}