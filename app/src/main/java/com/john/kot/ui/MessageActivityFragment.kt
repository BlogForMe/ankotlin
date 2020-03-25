package com.john.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.sysdialog.ItemPickDialog
import com.android.util.ToastUtil
import com.john.kot.R
import com.john.kot.ui.fragment.DialogShowFragment
import kotlinx.android.synthetic.main.actiivty_framgent_message.*

class MessageActivityFragment : AppCompatActivity(), ItemPickDialog.ISelectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actiivty_framgent_message)

//        iv_img.setOnClickListener {
////            Timber.i("img width ${iv_img.width}     img height  ${iv_img.height}")
//            var dArr = arrayListOf("红色","绿色","蓝色")
//            ItemPickDialog.newInstance("请选择测量项",dArr).show(supportFragmentManager,"")
//
//        }

        bt_go_fragment_first.setOnClickListener {
           supportFragmentManager.beginTransaction().add(R.id.fl_content, DialogShowFragment.newInstance()).commit()
        }

        dialog_call_activity.setOnClickListener {
            var dArr = arrayListOf("红色","绿色","蓝色")
            ItemPickDialog.newInstance("请选择测量项",dArr).show(supportFragmentManager,"")
        }
    }

    override fun getItemPosition(position: Int) {
        ToastUtil.showBiggerText(" 显示 $position")
    }

}
