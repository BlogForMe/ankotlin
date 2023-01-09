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

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.john.kot.databinding.ItemAmmountBinding
import com.john.kot.databinding.TextRowItemBinding
import kotlinx.android.synthetic.main.item_ammount.view.*
import kotlinx.android.synthetic.main.text_row_item.view.*

class CustomAdapter(val mDataSet: List<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private val TAG_CLASS = "CustomAdapter"

    var listener: OnItemClickListener? = null

    class ViewHolder(biding: ItemAmmountBinding) : RecyclerView.ViewHolder(biding.root)
//    class ViewHolder(v: TextRowItemBinding) : RecyclerView.ViewHolder(v.root)


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemAmmountBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        val viewHolder = ViewHolder(binding)
        Log.i(TAG_CLASS, "onCreateViewHolder: $viewHolder")
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.i(TAG_CLASS, "onBindViewHolder: $viewHolder")
        viewHolder.itemView.amount_tv.text = mDataSet[position]
        viewHolder.itemView.setOnClickListener {
            listener?.onItemClick(viewHolder.itemView, position)
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }


}