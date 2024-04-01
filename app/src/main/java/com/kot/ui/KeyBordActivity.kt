package com.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.kot.R
import com.kot.databinding.ActivityKeyBordBinding

class KeyBordActivity : AppCompatActivity() {

    val binding by viewBinding(ActivityKeyBordBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_key_bord)

        // demo 中默认 LimitEditText 只能输入字母数字和标点符号


        // 延时主要是更方便观察
        window.decorView.postDelayed({
            // 注意,获得焦点需要自己再处理下,其实很简单,如下:
            binding.letMain.isFocusable = true
            binding.letMain.isFocusableInTouchMode = true
            binding.letMain.requestFocus()
        }, 1000)
    }
}