package com.comm.util.component.fragment.life

import android.content.Intent
import android.os.Build.VERSION_CODES.HONEYCOMB
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.comm.util.R
import com.comm.util.base.BaseActivity
import com.comm.util.component.launchmode.ThirdActivity
import timber.log.Timber

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
            initFragment()
        }

    }


    private fun initFragment() {
//        var lifeFragment = supportFragmentManager.findFragmentById(R.id.fl_content)
//        if (lifeFragment == null) {
        val lifeFragment = LifeFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_content, lifeFragment)
        ft.commitAllowingStateLoss()
        val isDD = lifeFragment.isAdded
        Log.i("LifeActivity", "LifeFragment ${lifeFragment.isAdded}")
        if (lifeFragment.isAdded.not())
            ft.commitAllowingStateLoss()
//        ft.commitNow()
//        ft.commitNowAllowingStateLoss()
//        }
    }
}