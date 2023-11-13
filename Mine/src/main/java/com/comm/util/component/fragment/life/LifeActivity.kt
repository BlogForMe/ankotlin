package com.comm.util.component.fragment.life

import android.os.Bundle
import android.widget.Button
import com.comm.util.R
import com.comm.util.base.BaseActivity

/**
 * 横竖屏切换 查看Fragment生命周期
 */

class LifeActivity : BaseActivity() {
    private val tag = "life_fragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        findViewById<Button>(R.id.bt_commit).setOnClickListener {
            initFragment()
//            ItemPickDialog.newInstance().show(supportFragmentManager, "DialogFragment")
//            ItemPickDialog.newInstance().show(supportFragmentManager, "DialogFragment")
        }
    }


    private fun initFragment() {
        val lifeFragment = LifeFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_content, lifeFragment)
//        ft.commit()
        ft.commitNow()
    }

}