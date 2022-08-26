package com.john.kot.mvvm.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        val viewModel = ViewModelProvider(this)[UserModel::class.java]
        viewModel.user.observe(
            this
        ) {
            Log.i("ViewModelActivity", "onCreate: $it")
        }

        bt_do_action.setOnClickListener {
            viewModel.doAction()
        }


    }
}
