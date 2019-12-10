package com.john.kot.elec

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.util.DataUtil
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_elec.*

class ElecActivity : AppCompatActivity() {

   private var ss:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elec)
    }

    fun show(view: View) {
        val mylist = DataUtil.loadDatas(this)
        pathView.setData(mylist)
//        ss!!.toString()
    }
}
