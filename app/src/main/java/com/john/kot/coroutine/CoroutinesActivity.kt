package com.john.kot.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.bean.BaseMeta
import com.blankj.utilcode.util.LogUtils
import com.john.kot.databinding.ActivityCoroutinesBinding

class CoroutinesActivity : AppCompatActivity() {
    //    val binding by viewBinding(ActivityCoroutinesBinding::inflate)
    val binding by lazy { ActivityCoroutinesBinding.inflate(layoutInflater) }

    lateinit var baseMeta: BaseMeta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btCoroutines01.setOnClickListener {
            LogUtils.d(baseMeta)
        }
    }
}

//class A {
//    val b: B = B.getInstance()
//}
//
//class B {
//    companion object {
//        val b = B()
//        fun getInstance(): B {
//            return b
//        }
//    }
//}