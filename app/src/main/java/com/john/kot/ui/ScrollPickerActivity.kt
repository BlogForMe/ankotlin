package com.john.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_scorll_picker.*


class ScrollPickerActivity : AppCompatActivity() {

    private  lateinit var stringData: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scorll_picker)
        initData()
        horizon.setData(stringData)
        bt_bottom.setOnClickListener {
        }

        bt_left.setOnClickListener {
            horizon.setAnLeftOffset()
        }

        bt_right.setOnClickListener {
            horizon.setAnRightOffset()
        }

    }

    fun initData() {
        stringData = ArrayList()
        for (i in 350..1000) {
            stringData.add(((i/10.0).toString()+"0"))
        }
    }


}
