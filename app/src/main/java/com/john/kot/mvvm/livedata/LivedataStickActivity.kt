package com.john.kot.mvvm.livedata

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.john.kot.BaseActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityLivedataStickBinding
import com.john.kot.mvvm.livedata.stick.StickFragment
import com.john.kot.mvvm.livedata.stick.StickViewModel
import com.john.kot.util.viewBinding

class LivedataStickActivity : AppCompatActivity() {
    private val TAG = "LivedataStickActivity"
    val binding by viewBinding(ActivityLivedataStickBinding::inflate)

    //    val viewModel by viewModels<StickViewModel>()
    private lateinit var viewModel: StickViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fm_container, StickFragment.newInstance())
//            .commit()
        viewModel = ViewModelProvider(this)[StickViewModel::class.java]


        binding.btFirst.setOnClickListener {
            startActivity(Intent(this, LivedataStick02Activity::class.java))
        }
        binding.btSendData.setOnClickListener {
            viewModel.textLiveData.value = "text1"
            viewModel.textLiveData.observe(this, object : Observer<String> {
                override fun onChanged(t: String?) {
                    Log.i(TAG, "onChanged: $t")
                }
            })
        }
    }
}