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
package com.kot.arch.recyclerview

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kot.databinding.ItemAmmountBinding

class CustomAdapter(val mDataSet: List<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private val TAG_CLASS = "CustomAdapter"

    var listener: OnItemClickListener? = null

    class ViewHolder(biding: ItemAmmountBinding) : RecyclerView.ViewHolder(biding.root)
//    class ViewHolder(biding: ItemAmmountSimpleBinding) : RecyclerView.ViewHolder(biding.root)


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemAmmountBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
//        val binding =
//            ItemAmmountSimpleBinding.inflate(
//                LayoutInflater.from(viewGroup.context),
//                viewGroup,
//                false
//            )
        val viewHolder = ViewHolder(binding)
        Log.i(TAG_CLASS, "onCreateViewHolder: $viewHolder")
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.i(TAG_CLASS, "onBindViewHolder: $viewHolder")
//        viewHolder.itemView.amount_tv.text = mDataSet[position]

//        if (mDataSet.size.minus(1) == position) {
//            viewHolder.itemView.rm_tv.visibility = View.GONE
//        }
        viewHolder.itemView.setOnClickListener {
            listener?.onItemClick(viewHolder.itemView, position)
        }
        Handler(Looper.myLooper()!!).post {
            val width = viewHolder.itemView.width
            Log.i(TAG, "${mDataSet[position]} itemWidth: $width")
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }


}