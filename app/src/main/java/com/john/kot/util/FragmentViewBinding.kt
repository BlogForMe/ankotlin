package com.john.kot.util

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KProperty

/**
 *
 * ClassName:      FragmentViewBinding
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/11/15
 * UpdateUser:     zh
 * UpdateDate:     2022/11/15
 * UpdateRemark:   Modify the description
 */

class FragmentViewBinding<T : ViewBinding>(classes: Class<T>, fragment: Fragment) :
    FragmentDelegate<T>(fragment) {

    private val layoutInflater = classes.inflateMethod()

    private val bindView = classes.bindMethod()


    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T = viewBinding ?: let {
        val bind: T = (if (thisRef.view == null)
            layoutInflater.invoke(null, thisRef.layoutInflater)
        else bindView.invoke(null, thisRef.view)) as T
        viewBinding = bind
        bind
    }
}
