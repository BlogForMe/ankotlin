package com.john.kot.mvvm.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R

class MvvMFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_fragment)

//        supportFragmentManager.beginTransaction().add(R.id.fcv_content,MvvmFragment.newInstance()).commit()
    }
}