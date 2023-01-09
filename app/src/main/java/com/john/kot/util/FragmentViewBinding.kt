package com.john.kot.util

import android.util.Log
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

    private val TAG = "TAG"

    private val layoutInflater = classes.inflateMethod()

    private val bindView = classes.bindMethod()

    //调用getValue属于属性代理,访问viewbiding属性调用getVaule方法
    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T = viewBinding ?: let {

        Log.i(TAG, "getValue: $layoutInflater  $bindView")

        val bind: T = (if (thisRef.view == null) {
            layoutInflater.invoke(null, thisRef.layoutInflater) //  ActivityCBinding.inflate()
        } else {
            bindView.invoke(null, thisRef.view) //ActivityCBinding.bind()
        }) as T
        viewBinding = bind
        bind
    }
}
