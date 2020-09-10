package com.john.kot.mvvm.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.kot.R
import com.john.kot.mvvm.scrap.BodyDataFragment.Companion.newInstance

class MvvMFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_fragment)

        supportFragmentManager.beginTransaction().add(R.id.fcv_content,MvvmFragment.newInstance()).commit()
    }
}