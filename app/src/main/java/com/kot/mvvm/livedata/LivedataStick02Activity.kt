package com.kot.mvvm.livedata

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityLiveData02Binding
import com.kot.mvvm.livedata.stick.StickViewModel

class LivedataStick02Activity : com.kot.BaseActivity() {
//    override val TAG = "LivedataStick02Activity"

    val binding by viewBinding(ActivityLiveData02Binding::inflate)

    //    val viewModel by viewModels<StickViewModel>()
    private lateinit var viewModel: StickViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[StickViewModel::class.java]

//        viewModel.textLiveData.observe(this, object : Observer<String> {
//            override fun onChanged(t: String) {
//                Log.i(TAG, "onChanged: $t")
//            }
//        })

        LivedataStickActivity.livedata.observe(this,Observer{
            Log.i(TAG, "onCreate: $it")
        })
    }
}