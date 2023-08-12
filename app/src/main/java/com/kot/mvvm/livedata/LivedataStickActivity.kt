package com.kot.mvvm.livedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityLivedataStickBinding
import com.kot.mvvm.livedata.stick.StickViewModel

class LivedataStickActivity : AppCompatActivity() {
    private val TAG = "LivedataStickActivity"
    val binding by viewBinding(ActivityLivedataStickBinding::inflate)

    //    val viewModel by viewModels<StickViewModel>()
    private lateinit var viewModel: StickViewModel

    companion object {
        val livedata = MutableLiveData<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fm_container, StickFragment.newInstance())
//            .commit()
        viewModel = ViewModelProvider(this)[StickViewModel::class.java]

        binding.mainClick.setOnClickListener {
            livedata.value = "mainClick"
        }

        val lifecycle: LifecycleOwner? = null

        val atLeast = lifecycle?.lifecycle?.currentState?.isAtLeast(Lifecycle.State.DESTROYED)==true
        binding.btFirst.setOnClickListener {
//            startActivity(Intent(this, LivedataStick02Activity::class.java))
//            finish()
            Log.i(TAG, "onCreate: $atLeast")
        }

        viewModel.textLiveData.value = "text1"

        binding.btSendData.setOnClickListener {
            viewModel.textLiveData.observe(this, object : Observer<String> {
                override fun onChanged(t: String) {
                    Log.i(TAG, "onChanged: $t")
                    binding.btFirst.text = t

                }
            })
        }
    }


    override fun onStop() {
        super.onStop()
        val finishState = this.isDestroyed()

        Log.i(TAG, "onStop: $finishState")
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy: ${this.isFinishing()}")
        super.onDestroy()
    }


}