package com.john.kot.ui.elec

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.util.DataUtil

class ElecActivity : AppCompatActivity() {

   private var ss:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elec)
    }

    fun show(view: View) {
        val mylist = DataUtil.loadDatas(this)
//        pathView.setData(mylist)
//        ss!!.toString()
    }
}
