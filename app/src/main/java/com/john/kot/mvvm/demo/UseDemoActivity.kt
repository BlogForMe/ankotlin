package com.john.kot.mvvm.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.john.kot.R
import com.john.kot.databinding.ActivityUseDemoBinding

/**
 * https://www.jianshu.com/p/699cf6117b53
 */
class UseDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mainBinding = DataBindingUtil.setContentView<ActivityUseDemoBinding>(this, R.layout.activity_use_demo)
        mainBinding.userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        mainBinding.lifecycleOwner = this
    }
}