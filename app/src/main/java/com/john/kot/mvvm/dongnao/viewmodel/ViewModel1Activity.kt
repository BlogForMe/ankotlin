package com.john.kot.mvvm.dongnao.viewmodel

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.john.kot.R
import java.lang.String

class ViewModel1Activity : AppCompatActivity() {
    private var textView: TextView? = null
    private var viewModel: MyViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model1)
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        textView = findViewById<View>(R.id.textview) as TextView
        textView!!.text = String.valueOf(viewModel!!.number)
    }

    fun plusNumber(view: View?) {
        textView?.text = viewModel!!.number.toString()

        viewModel?.getName()
    }
}