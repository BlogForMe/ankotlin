package com.comm.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object ActivityUtil {

    fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment, frameId: Int) {
        val ft = manager.beginTransaction().add(frameId, fragment)
        ft.commit()
    }
}