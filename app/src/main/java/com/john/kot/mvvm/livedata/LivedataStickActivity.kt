package com.john.kot.mvvm.livedata

import android.os.Bundle
import com.john.kot.BaseActivity
import com.john.kot.R
import com.john.kot.mvvm.livedata.stick.StickFragment

class LivedataStickActivity : BaseActivity() {
    //    val binding by lazy { ActivityLivedataStickBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata_stick)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fm_container, StickFragment.newInstance())
            .commit()
    }
}