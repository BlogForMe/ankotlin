package com.comm.util.ui.tab

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.android.util.viewbind.viewBinding
import com.comm.util.R
import com.comm.util.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayout

/**
 * https://jonzhou.com/2017/12/26/TabLayout/
 * 动态Tab和样式修改
 */
class TabLayoutActivity : AppCompatActivity() {
    private val tabTitles = arrayOf("血压", "血糖")
    var homeFragment: Fragment? = null
    var healthFragment: Fragment? = null
    private val binding by viewBinding(ActivityTabLayoutBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTab()

        binding.tbLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                showFragment(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        homeFragment = HomeFragment()
        healthFragment = HealthFragment()
        showFragment(0)
    }

    private fun initTab() {
        for (text in tabTitles) {
            binding.tbLayout.addTab(binding.tbLayout.newTab().setText(text))
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

    private var preFragment: Fragment? = null
    private fun showFragment(index: Int) {
        val ft = supportFragmentManager.beginTransaction()
        val f = if (index == 0) {
            homeFragment as Fragment
        } else {
            healthFragment as Fragment
        }

        if (preFragment != null && !preFragment?.isHidden!!) {
            ft.hide(preFragment!!)
        }
        if (f.isAdded) {
            ft.show(f)
        } else {
            ft.add(R.id.fl_content, f)
        }
        ft.commit()
        preFragment = f
    }

//    private fun hideFragment(ft: FragmentTransaction) {
//        if (homeFragment != null) {
//            ft.hide(homeFragment!!)
//        }
//        if (healthFragment != null) {
//            ft.hide(healthFragment!!)
//        }
//    }

//    private fun showFragment(index: Int) {
//        val ft = supportFragmentManager.beginTransaction()
//        hideFragment(ft)
//        when (index) {
//            0 -> if (homeFragment == null) {
//                homeFragment = HomeFragment()
//                ft.add(R.id.fl_content, homeFragment!!, HomeFragment::class.java.name)
//            } else {
//                ft.show(homeFragment!!)
//            }
//            1 -> if (healthFragment == null) {
//                healthFragment = HealthFragment()
//                ft.add(R.id.fl_content, healthFragment!!, HealthFragment::class.java.name)
//            } else {
//                ft.show(healthFragment!!)
//            }
//        }
//        ft.addToBackStack(null)
//        ft.commit()
//    }
}