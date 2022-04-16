package com.john.kot.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import my.com.tngdigital.common.viewbinding.FragmentViewBindingDelegate

/**
 *
 * ClassName:      ActivityViewBinding
 * Description:    Description
 * Author:         SongLei
 * CreateDate:     7/1/21 1:35 PM
 * UpdateUser:     SongLei
 * UpdateDate:     7/1/21 1:35 PM
 * UpdateRemark:   Modify the description
 */

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T,
    isSetContent: Boolean = true,
    viewGroup: ViewGroup? = null,
    attach: Boolean = false,
) = lazy {
    val invoke = bindingInflater.invoke(layoutInflater, viewGroup, attach)
    if (isSetContent) setContentView(invoke.root) //可选
    invoke
}

fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)



