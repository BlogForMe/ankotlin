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

import android.animation.Animator
import android.animation.ValueAnimator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.john.kot.R
import com.john.kot.anim.animationUrl1
import com.john.kot.anim.animationUrl2
import com.john.kot.anim.model.AnimServiceListener

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private val TAG_CLASS = "CustomAdapter"
    private val TAG_LIFE = "LIFECYCLE"

    private var mDataSet: Array<String?>? = null

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView = v.findViewById(R.id.textView)
        val lottieAnimView: LottieAnimationView = v.findViewById(R.id.home_service_img)
    }

    fun setList(dataSet: Array<String?>?) {
        mDataSet = dataSet
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)
        val viewHolder = ViewHolder(v)
        Log.i(TAG_CLASS, "onCreateViewHolder: $viewHolder")
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.i(TAG_CLASS, "onBindViewHolder: $viewHolder")
        viewHolder.textView.text = mDataSet!![position]
        val animationView = viewHolder.lottieAnimView
        when (position) {
            1 -> playAnim(animationView, animationUrl1)
            2 -> playAnim(animationView, animationUrl2)
            else -> animationView.setImageResource(R.mipmap.ic_launcher)
        }
        if (position == 1 || position == 2) {
            animationView.addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {
                    Log.i(TAG_LIFE, " onAnimationStart: $animationView ")
                }

                override fun onAnimationEnd(p0: Animator?) {
                    Log.i(TAG_LIFE, "onAnimationEnd: $animationView")
                }

                override fun onAnimationCancel(p0: Animator?) {
                    Log.i(TAG_LIFE, "onAnimationCancel: $animationView")
                }

                override fun onAnimationRepeat(p0: Animator?) {
                    Log.i(TAG_LIFE, "onAnimationRepeat: $animationView")
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return if (mDataSet == null) {
            0
        } else mDataSet!!.size
    }


    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        Log.i(TAG_CLASS, "onViewDetachedFromWindow: $holder")
        val animationView = holder.lottieAnimView
        when (holder.absoluteAdapterPosition) {
            1,2 -> animationView.pauseAnimation()
        }
    }

//    override fun onViewAttachedToWindow(holder: ViewHolder) {
//        super.onViewAttachedToWindow(holder)
//        Log.i(TAG, "onViewAttachedToWindow: $holder")
//        val animationView = holder.lottieAnimView
//        when (holder.absoluteAdapterPosition) {
//            2 -> animationView.resumeAnimation()
//        }
//    }


    private fun playAnim(animationView: LottieAnimationView, animationUrl: String) {
        Log.i(TAG_CLASS, "playAnim: ")
        animationView.setFailureListener {
            animationView.setImageResource(R.drawable.ic_go_pinjam)
        }
        animationView.setAnimationFromUrl(animationUrl)
        animationView.playAnimation()
        animationView.repeatCount = ValueAnimator.INFINITE
        animationView.backgroundTintMode
    }
}