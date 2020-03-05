package com.john.kot.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.util.ItemPickDialog
import com.android.util.ToastUtil
import com.android.util.base.CBaseFragment
import com.john.kot.R
import kotlinx.android.synthetic.main.fragment_stack_two.*

class DialogShowFragment : CBaseFragment() ,ItemPickDialog.ISelectListener{


    companion object {
       fun newInstance():Fragment{
           return DialogShowFragment()
       }
    }
    override fun setLayoutId(): Int {
        return  R.layout.fragment_stack_two
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        id_fragment_call_one.setOnClickListener {
            var dArr = arrayListOf("红色","绿色","蓝色")
            ItemPickDialog.newInstance("请选择测量项",dArr).show(childFragmentManager,"")
        }
    }

    override fun getItemPosition(position: Int) {
        ToastUtil.showBiggerText("位置 $position")
    }
}