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

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private var mDataSet: Array<String?>? = null
    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView
        val lottieAnimView: LottieAnimationView

        init {
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
            textView = v.findViewById<View>(R.id.textView) as TextView
            lottieAnimView = v.findViewById<View>(R.id.home_service_img) as LottieAnimationView
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    //    public CustomAdapter(String[] dataSet) {
    //        mDataSet = dataSet;
    //    }
    fun setList(dataSet: Array<String?>?) {
        mDataSet = dataSet
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)
        Log.i(TAG, "onViewAttachedToWindow: ${viewGroup}")
        return ViewHolder(v)
    }

    // END_INCLUDE(recyclerViewOnCreateViewHolder)
    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set.")

        Log.i(TAG, "onViewDetachedFromWindow: ${viewHolder.adapterPosition}  Element $position set.")
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.textView.text = mDataSet!![position]
        val animationView = viewHolder.lottieAnimView
        when (position) {
            1 -> playAnim(animationView, animationUrl1)
            2 -> playAnim(animationView, animationUrl2)
            else -> animationView.setImageResource(R.mipmap.ic_launcher)
        }
    }

    // END_INCLUDE(recyclerViewOnBindViewHolder)
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return if (mDataSet == null) {
            0
        } else mDataSet!!.size
    }


    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        Log.i(TAG, "onViewDetachedFromWindow: ${holder.adapterPosition}")
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        Log.i(TAG, "onViewAttachedToWindow: ${holder.adapterPosition}")
    }

    companion object {
        private const val TAG = "CustomAdapter"
    }

    private fun playAnim(animationView: LottieAnimationView, animationUrl: String) {
        animationView.setFailureListener {
            animationView.setImageResource(R.drawable.ic_go_pinjam)
        }
        animationView.setAnimationFromUrl(animationUrl)
        animationView.playAnimation()
        animationView.repeatCount = ValueAnimator.INFINITE
        animationView.backgroundTintMode
    }
}