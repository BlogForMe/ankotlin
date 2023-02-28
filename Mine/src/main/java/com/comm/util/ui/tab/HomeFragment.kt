package com.comm.util.ui.tab

import android.view.View
import androidx.fragment.app.Fragment
import com.comm.util.R
import com.comm.util.base.BaseFragment

/**
 * @author : John
 * @date : 2018/7/18
 */
class HomeFragment : Fragment(R.layout.fragment_first) {

    companion object {
        @JvmStatic
        fun newInstance(): Fragment {
            return HomeFragment()
        }
    }
}