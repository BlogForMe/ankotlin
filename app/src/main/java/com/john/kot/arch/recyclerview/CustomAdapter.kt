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
import com.john.kot.databinding.TextRowItemBinding
import kotlinx.android.synthetic.main.text_row_item.view.*

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private val TAG_CLASS = "CustomAdapter"
    private val TAG_LIFE = "LIFECYCLE"

    private var mDataSet: Array<String?>? = null
    var listener: OnItemClickListener? = null

    class ViewHolder(v: TextRowItemBinding) : RecyclerView.ViewHolder(v.root)
    fun setList(dataSet: Array<String?>?) {
        mDataSet = dataSet
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            TextRowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        val viewHolder = ViewHolder(binding)
        Log.i(TAG_CLASS, "onCreateViewHolder: $viewHolder")
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.i(TAG_CLASS, "onBindViewHolder: $viewHolder")
        viewHolder.itemView.textView.text = mDataSet!![position]
        viewHolder.itemView.setOnClickListener {
            listener?.onItemClick(viewHolder.itemView, position)
        }
//        val animationView = viewHolder.lottieAnimView
//        when (position) {
//            1 -> playAnim(animationView, animationUrl1)
//            2 -> playAnim(animationView, animationUrl2)
//            else -> animationView.setImageResource(R.mipmap.ic_launcher)
//        }
//        if (position == 1 || position == 2) {
//            animationView.addAnimatorListener(object : Animator.AnimatorListener {
//                override fun onAnimationStart(animation: Animator) {
//                    Log.i(TAG_LIFE, " onAnimationStart: $animationView ")
//                }
//
//                override fun onAnimationEnd(animation: Animator) {
//                    Log.i(TAG_LIFE, "onAnimationEnd: $animationView")
//                }
//
//                override fun onAnimationCancel(animation: Animator) {
//                    Log.i(TAG_LIFE, "onAnimationCancel: $animationView")
//                }
//
//                override fun onAnimationRepeat(animation: Animator) {
//                    Log.i(TAG_LIFE, "onAnimationRepeat: $animationView")
//                }
//
//            })
//        }
    }

    override fun getItemCount(): Int {
        return if (mDataSet == null) {
            0
        } else mDataSet!!.size
    }


    override fun onViewDetachedFromWindow(holder: ViewHolder) {
//        super.onViewDetachedFromWindow(holder)
//        Log.i(TAG_CLASS, "onViewDetachedFromWindow: $holder")
//        val animationView = holder.lottieAnimView
//        when (holder.absoluteAdapterPosition) {
//            1, 2 -> animationView.pauseAnimation()
//        }
    }


//    private fun playAnim(animationView: LottieAnimationView, animationUrl: String) {
//        Log.i(TAG_CLASS, "playAnim: ")
//        animationView.setFailureListener {
//            animationView.setImageResource(R.drawable.ic_go_pinjam)
//        }
//        animationView.setAnimationFromUrl(animationUrl)
//        animationView.playAnimation()
//        animationView.repeatCount = ValueAnimator.INFINITE
//        animationView.backgroundTintMode
//    }
}