package com.john.kot.mvvm.livedata

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.john.kot.R

/**
 * https://www.jianshu.com/p/e08287ec62cd
 */
class LiveDataTestActivity : AppCompatActivity() {
    private var mViewModel: CustomViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        mViewModel = ViewModelProviders.of(this).get(CustomViewModel::class.java)
        val liveData = mViewModel!!.liveData
        liveData.observe(this, object : Observer<Int> {
            override fun onChanged(integer: Int) {
                Log.e(TAG, "参数返回： $integer")
                liveData.removeObserver(this)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed(Runnable {
            val liveData = mViewModel!!.liveData
            liveData.observe(this, object : Observer<Int>{
                override fun onChanged(integer: Int) {
                    Log.e(TAG, "参数返回： $integer")
                }
            })
        }, 5000)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}