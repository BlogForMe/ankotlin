package com.comm.util.component.fragment.life

import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.comm.util.R
import com.comm.util.base.BaseActivity
import com.comm.util.dialog.DialogActivity
import com.comm.util.dialog.InvestPwdDialog

/**
 * 横竖屏切换 查看Fragment生命周期
 */

class LifeActivity : BaseActivity() {
    val tag = "life_fragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        findViewById<Button>(R.id.bt_life).setOnClickListener {
//            startActivity(Intent(this, ThirdActivity::class.java))
//            initFragment()

            val invest = InvestPwdDialog()
//            invest.show(supportFragmentManager, "InvestPwdDialog")
            InvestPwdDialog.newInstance().show(supportFragmentManager, "InvestPwdDialog")
            InvestPwdDialog.newInstance().show(supportFragmentManager, "InvestPwdDialog")
            Log.i(TAG, "onCreate: invest $invest ")
        }

    }


    private fun initFragment() {
        var lifeFragment = supportFragmentManager.findFragmentByTag("InvestPwdDialog")
        if (lifeFragment == null) lifeFragment = LifeFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_content, lifeFragment, "lifeFragmenttag")
        ft.commitAllowingStateLoss()
        val isDD = lifeFragment.isAdded
        Log.i("LifeActivity", "LifeFragment ${lifeFragment.isAdded}")

//        val ft1 = supportFragmentManager.beginTransaction()
//        ft1.add(R.id.fl_content, lifeFragment)
//        ft1.commitAllowingStateLoss()


        val findFragmentByTag = supportFragmentManager.findFragmentByTag("lifeFragmenttag")
        Log.i(TAG, "initFragment: $lifeFragment findFragmentByTag $findFragmentByTag ")
//        if (lifeFragment.isAdded.not())
//            ft.commitAllowingStateLoss()
//        ft.commitNow()
//        ft.commitNowAllowingStateLoss()
//        }
    }
}