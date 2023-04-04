package com.john.kot.mvvm.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber

class LiveDataActivity : AppCompatActivity() {
    private lateinit var myViewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_live_data)
        myViewModel = ViewModelProvider(this).get(ListViewModel::class.java)

//        var binding = DataBindingUtil.setContentView<ActivityLiveDataBindingImpl>(
//            this,
//            R.layout.activity_live_data
//        )
//        binding.lifecycleOwner = this
//        binding.viewmodel = myViewModel

        var i = 1
//        bt_click.setOnClickListener {
//            myViewModel.userClicksOnButton()
        myViewModel.isShow.value = i++
        Timber.i("i ${myViewModel.isShow.value}")
        myViewModel.isVisible.value = true
//        }

//        bt_hide.setOnClickListener {
//            myViewModel.isVisible.value = false
//        }
    }


    override fun onResume() {
        super.onResume()
        myViewModel.navigateToDetails.observe(this, Observer {
            Timber.i("navigateToDetails $it")
//            if (it) startActivity(Intent(this, DetailLiveActivity::class.java))
        })

    }
}