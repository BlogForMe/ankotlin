package com.kot.mvvm.scrap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kot.R

class StrapFragment : Fragment() {

    companion object {
        fun newInstance() = StrapFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.strap_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        tb_layout.addTab(tb_layout.newTab().setText("体征"))
//        tb_layout.addTab(tb_layout.newTab().setText("睡眠"))

        childFragmentManager.beginTransaction()
            .replace(R.id.fcv_content, BodyDataFragment.newInstance())
            .commit()

//        tb_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabReselected(p0: TabLayout.Tab?) {
//            }
//
//            override fun onTabUnselected(p0: TabLayout.Tab?) {
//            }
//
//            override fun onTabSelected(p0: TabLayout.Tab?) {
//                if (p0?.text == "体征") {
//
//                } else if (p0?.text == "睡眠") {
//
//                }
//            }
//        })
    }

}
