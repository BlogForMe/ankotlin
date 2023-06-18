package com.comm.util.ui.tab

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.comm.util.R
import com.google.android.material.tabs.TabLayout

/**
 * https://jonzhou.com/2017/12/26/TabLayout/
 * 动态Tab和样式修改
 */
class TabLayoutActivity : AppCompatActivity() {
    var tabTitles = arrayOf("血压", "血糖")
    var homeFragment: Fragment? = null
    var healthFragment: Fragment? = null
    private var tabLayout: TabLayout? = null
    private var flContent: FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        tabLayout = findViewById(R.id.tb_layout)
        flContent = findViewById(R.id.fl_content)
        initTab()

        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                showFragment(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun initTab() {
        for (text in tabTitles) {
            tabLayout?.addTab(tabLayout!!.newTab().setText(text))
        }
//        for (i in tabTitles.indices) {
//            val tab = tabLayout!!.getTabAt(i)
//            tab!!.setCustomView(R.layout.tab_item)
//            val tvItemTitle = tab.customView!!.findViewById<TextView>(R.id.tv_item_title)
//            tvItemTitle.text = tabTitles[i]
//            if (i == tabTitles.size - 1) {
//                tab.customView!!.findViewById<View>(R.id.view_line).visibility =
//                    View.GONE
//            }
//        }
    }

    private fun showFragment(index: Int) {
        val ft = supportFragmentManager.beginTransaction()
        hideFragment(ft)
        when (index) {
            0 -> if (homeFragment == null) {
                homeFragment = HomeFragment()
                ft.add(R.id.fl_content, homeFragment!!, HomeFragment::class.java.name)
            } else {
                ft.show(homeFragment!!)
            }
            1 -> if (healthFragment == null) {
                healthFragment = HealthFragment()
                ft.add(R.id.fl_content, healthFragment!!, HealthFragment::class.java.name)
            } else {
                ft.show(healthFragment!!)
            }
        }
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun hideFragment(ft: FragmentTransaction) {
        if (homeFragment != null) {
            ft.hide(homeFragment!!)
        }
        if (healthFragment != null) {
            ft.hide(healthFragment!!)
        }
    }
}