package com.kot.ui.constraint

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.kot.databinding.ActivityConstraintConerBinding

//    https://juejin.cn/post/6949186887609221133
class ConstraintAngerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConstraintConerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.i("ConstraintAngerActivity", "handleOnBackPressed: ")
            }
        })
    }
}