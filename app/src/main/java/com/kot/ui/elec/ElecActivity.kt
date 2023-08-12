package com.kot.ui.elec

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kot.R

class ElecActivity : AppCompatActivity() {

   private var ss:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elec)
    }

    fun show(view: View) {
        val mylist = com.kot.util.DataUtil.loadDatas(this)
//        pathView.setData(mylist)
//        ss!!.toString()
    }
}
