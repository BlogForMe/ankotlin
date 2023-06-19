package com.android.util.viewbind

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 *
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

inline fun <reified T : ViewBinding> Fragment.viewBinding() =
    FragmentViewBinding(T::class.java, this)


