package com.john.kot.mvvm.dongnao.viewmodel

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityViewModelShareBinding
import com.john.kot.util.viewBinding


class ViewModelShareActivity : AppCompatActivity() {
    val viewBinding by viewBinding(ActivityViewModelShareBinding::inflate)
    val viewModel by viewModels<ShareViewModel>()
    private val TAG = "ViewModelShareActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, ViewModelFragment()).commitNow()


        viewBinding.button.setOnClickListener {
//            viewModel.number = 2
            val metrics = DisplayMetrics()
            getWindowManager().getDefaultDisplay().getMetrics(metrics)
            metrics.density
            Log.i(TAG, "onCreate lineCount : ${viewBinding.button.lineCount}")
            Log.i(TAG, "onCreate: metrics.density ${metrics.density}")
        }

//        textView = findViewById<View>(R.id.textview) as TextView
//        textView!!.text = String.valueOf(viewModel!!.number)
//        textView?.text = viewModel!!.number.toString()
//        viewModel?.getName()
    }

}