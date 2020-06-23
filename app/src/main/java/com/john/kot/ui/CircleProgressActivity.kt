package com.john.kot.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.util.ToastUtil
import com.android.util.sysdialog.FireMissilesDialogFragment
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_circle_progress.*

class CircleProgressActivity : AppCompatActivity() , FireMissilesDialogFragment.IConfirmListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.ble_activity_temp)
        setContentView(R.layout.activity_circle_progress)

//        cav.progress("9999","100")
//        tv_confirm.setOnClickListener {
//            Timber.i("degree    "+trm_rule.getDegree())
//        }

        val scaleUnit =0.1f
//        bt_add.setOnClickListener {
//            FireMissilesDialogFragment.newInstance().show(supportFragmentManager,javaClass.toString())
//        }
    }

//    override fun onResume() {
//        super.onResume()
//        var degree= "37.0"
//        trm_rule.setDegree(degree)
//    }

    override fun positiveBt() {
        ToastUtil.showBiggerText("确定")
    }

    override fun negativeBt() {
        ToastUtil.showBiggerText("取消")
    }
}
