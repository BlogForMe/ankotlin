package com.john.kot.ui.constraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import com.john.kot.R
import com.john.kot.databinding.ActivityConstraintConerBinding
//    https://juejin.cn/post/6949186887609221133
class ConstraintAngerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityConstraintConerBinding.inflate(layoutInflater)
        setContentView(biding.root)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.i("ConstraintAngerActivity", "handleOnBackPressed: ")
            }
        })
    }
}