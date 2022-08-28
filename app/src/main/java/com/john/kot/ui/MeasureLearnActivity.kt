package com.john.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.sysdialog.ItemPickDialog
import com.john.kot.R
import com.john.kot.ui.dialog.DialogShowFragment
import timber.log.Timber

class MeasureLearnActivity : AppCompatActivity(), ItemPickDialog.ISelectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measure_learn)

        val scale = getResources().getDisplayMetrics().density
        Timber.i("scale $scale")


    }

    override fun getItemPosition(position: Int) {
        DialogShowFragment.newInstance()
    }

}
