package com.android.util.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import timber.log.Timber

/**
 * Created by jon on 12/9/17.
 */
abstract class BaseFragment(res: Int = 0) : Fragment(res) {
    protected var rootView: View? = null
    protected var mActivity: Activity? = null
    var TAG = javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        Timber.tag(TAG).d("onCreateView()")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as Activity
        super.onAttach(context) //为什么要放在这里  否则有些手机会崩
        Timber.tag(TAG).d("onAttach(Context context)")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Timber.tag(TAG).d("onHiddenChanged hidden   $hidden")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.tag(TAG).d("onActivityCreated()")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(TAG).d("onStart()")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(TAG).d("onResume()")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(TAG).d("onPause() ")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(TAG).d("onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag(TAG).d("onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(TAG).d("onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.tag(TAG).d("onDetach()")
    }


}