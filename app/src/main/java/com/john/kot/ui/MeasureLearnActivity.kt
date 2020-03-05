package com.john.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.circledialog.ItemPickDialog
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_measure_learn.*
import timber.log.Timber

class MeasureLearnActivity : AppCompatActivity(), ItemPickDialog.ISelectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measure_learn)

        iv_img.setOnClickListener {
//            Timber.i("img width ${iv_img.width}     img height  ${iv_img.height}")
            var dArr = arrayListOf("红色","绿色","蓝色")
            ItemPickDialog.newInstance("请选择测量项",dArr).show(supportFragmentManager,"")

        }
        val scale = getResources().getDisplayMetrics().density
        Timber.i("scale $scale")
    }

    override fun getItemPosition(position: Int) {

    }

}
