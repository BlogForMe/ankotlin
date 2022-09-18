package com.john.kot.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import com.android.util.sysdialog.FireMissilesDialogFragment
import com.john.kot.BaseActivity
import com.john.kot.R

class CircleProgressActivity : BaseActivity(), FireMissilesDialogFragment.IConfirmListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.ble_activity_temp)
        setContentView(R.layout.activity_circle_progress)

//        cav.progress("9999","100")
//        tv_confirm.setOnClickListener {
//            Timber.i("degree    "+trm_rule.getDegree())
//        }

//        bt_add.setOnClickListener {
//            FireMissilesDialogFragment.newInstance().show(supportFragmentManager,javaClass.toString())
//        }

        findViewById<Button>(R.id.bt_show_1).setOnClickListener {
//            Handler(Looper.getMainLooper()).postDelayed({
//                FireMissilesDialogFragment.newInstance()
//                    .show(supportFragmentManager,null)
//            }, 3000)

            Handler(Looper.getMainLooper()).postDelayed({
                FireMissilesDialogFragment.newInstance().showWithLifecycle(this)
            }, 3000)
        }

//        FireMissilesDialogFragment.newInstance()
//            .show(supportFragmentManager, javaClass.toString())

    }

    override fun onStart() {
        super.onStart()
        FireMissilesDialogFragment.newInstance().showWithLifecycle(this)
    }


//    override fun onResume() {
//        super.onResume()
//        var degree= "37.0"
//        trm_rule.setDegree(degree)
//    }

    override fun positiveBt() {
        Toast.makeText(this, "确定", Toast.LENGTH_SHORT).show()
    }

    override fun negativeBt() {
        Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show()
    }
}
