package com.john.kot.util

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty

/**
 *
 * ClassName:      FragmentDelegate
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/11/15
 * UpdateUser:     zh
 * UpdateDate:     2022/11/15
 * UpdateRemark:   Modify the description
 */


abstract class FragmentDelegate<T : ViewBinding>(
    fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {
    protected var viewBinding: T? = null

    init {
        fragment.lifecycle.observerWhenCreated {
            fragment.viewLifecycleOwnerLiveData.observe(fragment) {
                it.lifecycle.observerWhenDestroyed {
                    viewBinding = null
                }
            }
        }

    }

}
