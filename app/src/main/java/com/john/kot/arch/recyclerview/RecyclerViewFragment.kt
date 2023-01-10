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

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.util.sysdialog.ItemPickDialog
import com.john.kot.databinding.RecyclerViewFragBinding


class RecyclerViewFragment : Fragment(), ItemPickDialog.ISelectListener {
    val TAG = "RecyclerViewFragment"

    private var _binding: RecyclerViewFragBinding? = null
    private var mRecyclerViewModel: RecycleViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mRecyclerViewModel = ViewModelProvider(this).get(
            RecycleViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RecyclerViewFragBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mLayoutManager = LinearLayoutManager(activity)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        _binding?.recyclerView?.layoutManager = mLayoutManager

        val initDataset = mRecyclerViewModel!!.initDataset()
        val itemPadding = getItemPadding(initDataset, "RM", Typeface.DEFAULT)
        _binding?.recyclerView?.addItemDecoration(ItemTransferAmount(itemPadding))
        val mAdapter = CustomAdapter(initDataset)
        _binding?.recyclerView?.adapter = mAdapter
        mAdapter.listener = object : OnItemClickListener {
            override fun onItemClick(v: View?, position: Int) {
                Log.i(TAG, "onItemClick position: $position")
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getItemPosition(position: Int) {
    }
}