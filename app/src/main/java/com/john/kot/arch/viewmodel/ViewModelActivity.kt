package com.john.kot.arch.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_view_model.*
import timber.log.Timber

class ViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        val viewModel = ViewModelProvider(this).get(UserModel::class.java)
        viewModel.user.observe(this,
            Observer<List<User>> {
                //                    t -> Timber.i(t.toString())
                it.forEach { tmp ->
                    Timber.i(tmp.toString())
                }
            })

        bt_do_action.setOnClickListener {
            viewModel.doAction()
        }


    }
}
