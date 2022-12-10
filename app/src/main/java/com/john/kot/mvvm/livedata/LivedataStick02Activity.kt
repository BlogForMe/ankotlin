package com.john.kot.mvvm.livedata

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.john.kot.BaseActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityLivedataStickBinding
import com.john.kot.mvvm.livedata.stick.StickFragment
import com.john.kot.mvvm.livedata.stick.StickViewModel
import com.john.kot.util.viewBinding

class LivedataStick02Activity : AppCompatActivity() {
    val TAG = "LivedataStick02Activity"

    val binding by viewBinding(ActivityLivedataStickBinding::inflate)

    //    val viewModel by viewModels<StickViewModel>()
    private lateinit var viewModel: StickViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[StickViewModel::class.java]

        binding.btFirst
        viewModel.textLiveData.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.i(TAG, "onChanged: $t")
            }
        })
    }
}