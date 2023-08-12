package com.kot.ui.dialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.util.ToastUtil
import com.android.util.base.CBaseFragment
import com.android.util.sysdialog.ItemPickDialog
import com.kot.R

val dArr = arrayListOf("红色", "绿色", "蓝色")

class DialogShowFragment : CBaseFragment(),
    ItemPickDialog.ISelectListener {

    companion object {
        fun newInstance(): Fragment {
            return DialogShowFragment()
        }
    }

    override fun setLayoutId(): Int {
        return R.layout.fragment_stack_two
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        id_fragment_call_one.setOnClickListener {
//            ItemPickDialog.newInstance("请选择测量项", dArr).show(childFragmentManager, "")
//        }
    }

    override fun getItemPosition(position: Int) {
        ToastUtil.showBiggerText("位置 $position")
    }
}