package com.kot.mvvm.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kot.R

class LifeCycleActivity : AppCompatActivity() {
    val TAG = "LifeCycleActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        lifecycle.addObserver(LifecycleLifecycle())
    }

}