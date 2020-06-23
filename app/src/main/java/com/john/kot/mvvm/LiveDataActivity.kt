package com.john.kot.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.john.kot.R
import com.john.kot.mvvm.livedata.DetailLiveActivity
import com.john.kot.mvvm.livedata.ListViewModel
import kotlinx.android.synthetic.main.activity_live_data.*
import timber.log.Timber

class LiveDataActivity : AppCompatActivity() {
    private lateinit var myViewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
         myViewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        bt_click.setOnClickListener {
            myViewModel.userClicksOnButton()
        }
    }


    override fun onResume() {
        super.onResume()
        myViewModel.navigateToDetails.observe(this, Observer {
            Timber.i("navigateToDetails $it")
            if (it) startActivity(Intent(this, DetailLiveActivity::class.java))
        })

    }
}