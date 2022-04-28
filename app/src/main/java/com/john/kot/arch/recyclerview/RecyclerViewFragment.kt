/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.john.kot.arch.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.util.sysdialog.ItemPickDialog
import com.john.kot.R
import com.john.kot.anim.model.AnimServiceListener
import com.john.kot.ui.dialog.dArr
import com.john.kot.util.viewBinding

/**
 * Demonstrates the use of [RecyclerView] with a [LinearLayoutManager] and a
 * [GridLayoutManager].
 */
class RecyclerViewFragment : Fragment(), ItemPickDialog.ISelectListener {
    private var mRecyclerViewModel: RecycleViewModel? = null

    enum class LayoutManagerType {
        GRID_LAYOUT_MANAGER, LINEAR_LAYOUT_MANAGER
    }

    private var mCurrentLayoutManagerType: LayoutManagerType? = null
    private var mLinearLayoutRadioButton: RadioButton? = null
    private var mGridLayoutRadioButton: RadioButton? = null
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: CustomAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        mRecyclerViewModel = ViewModelProvider(this).get(
            RecycleViewModel::class.java
        )
        lifecycle.addObserver(AnimServiceListener())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.recycler_view_frag, container, false)
        rootView.tag = TAG

        rootView.findViewById<Button>(R.id.bt_show_dialog).setOnClickListener {
            ItemPickDialog.newInstance("请选择测量项", dArr).show(childFragmentManager, "")
        }

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = rootView.findViewById<View>(R.id.recyclerView) as RecyclerView

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = LinearLayoutManager(activity)
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER
        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = savedInstanceState
                .getSerializable(KEY_LAYOUT_MANAGER) as LayoutManagerType?
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType)
        mAdapter = CustomAdapter()
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView!!.adapter = mAdapter
        // END_INCLUDE(initializeRecyclerView)
        mLinearLayoutRadioButton = rootView.findViewById<View>(R.id.linear_layout_rb) as RadioButton
        mLinearLayoutRadioButton!!.setOnClickListener {
            setRecyclerViewLayoutManager(
                LayoutManagerType.LINEAR_LAYOUT_MANAGER
            )
        }
        mGridLayoutRadioButton = rootView.findViewById<View>(R.id.grid_layout_rb) as RadioButton
        mGridLayoutRadioButton!!.setOnClickListener { setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER) }
        mRecyclerViewModel!!.requestData.observe(viewLifecycleOwner) { data: Array<String?>? ->
            if (data != null) {
                mAdapter!!.setList(data)
                mAdapter!!.notifyDataSetChanged()
            }
        }
        mRecyclerViewModel!!.requestRecycleData()
        return rootView
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    fun setRecyclerViewLayoutManager(layoutManagerType: LayoutManagerType?) {
        var scrollPosition = 0

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView!!.layoutManager != null) {
            scrollPosition = (mRecyclerView!!.layoutManager as LinearLayoutManager?)
                ?.findFirstCompletelyVisibleItemPosition() ?: 0
        }
        when (layoutManagerType) {
            LayoutManagerType.GRID_LAYOUT_MANAGER -> {
                mLayoutManager = GridLayoutManager(activity, SPAN_COUNT)
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER
            }
            LayoutManagerType.LINEAR_LAYOUT_MANAGER -> {
                mLayoutManager = LinearLayoutManager(activity)
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER
            }
            else -> {
                mLayoutManager = LinearLayoutManager(activity)
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER
            }
        }
        mRecyclerView!!.layoutManager = mLayoutManager
        mRecyclerView!!.scrollToPosition(scrollPosition)
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType)
        super.onSaveInstanceState(savedInstanceState)
    }

    companion object {
        private const val TAG = "RecyclerViewFragment"
        private const val KEY_LAYOUT_MANAGER = "layoutManager"
        private const val SPAN_COUNT = 2
    }

    override fun getItemPosition(position: Int) {
    }
}