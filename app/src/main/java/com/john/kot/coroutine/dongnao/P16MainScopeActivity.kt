package com.john.kot.coroutine.dongnao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.john.kot.databinding.ActivityP16MainScopeBinding
import kotlinx.android.synthetic.main.activity_p16_main_scope.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class P16MainScopeActivity : AppCompatActivity() {
    val binding by lazy { ActivityP16MainScopeBinding.inflate(layoutInflater) }

    private val mainScope = MainScope()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.mainScope.setOnClickListener {
            mainScope.launch {
//                val user = userServiceApi.getUser("xx")
                binding.tvShow.text = "ff"
            }
        }
    }
}