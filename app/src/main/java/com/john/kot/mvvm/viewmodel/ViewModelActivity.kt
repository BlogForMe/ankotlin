package com.john.kot.mvvm.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.john.kot.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {
    val biding by lazy { ActivityViewModelBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        val viewModel = ViewModelProvider(this)[UserModel::class.java]
        viewModel.userLiveData.observe(this) {
            Log.i("ViewModelActivity", "onCreate: $it")
            biding.btDoAction.text = it[0].name
        }

        biding.btDoAction.setOnClickListener {
            viewModel.doAction()
        }


    }
}
