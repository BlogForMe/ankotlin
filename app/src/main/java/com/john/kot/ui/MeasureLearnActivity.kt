package com.john.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.ItemPickDialog
import com.john.kot.R
import com.john.kot.ui.fragment.DialogShowFragment
import kotlinx.android.synthetic.main.actiivty_framgent_message.*
import kotlinx.android.synthetic.main.activity_measure_learn.*
import timber.log.Timber

class MeasureLearnActivity : AppCompatActivity(), ItemPickDialog.ISelectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measure_learn)

        iv_img.setOnClickListener {
//            Timber.i("img width ${iv_img.width}     img height  ${iv_img.height}")

        }
        val scale = getResources().getDisplayMetrics().density
        Timber.i("scale $scale")


    }

    override fun getItemPosition(position: Int) {
        DialogShowFragment.newInstance()
    }

}
