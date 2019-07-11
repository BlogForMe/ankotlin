package com.john.ankotlin.elec

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.john.ankotlin.DataUtil
import com.john.ankotlin.R
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
