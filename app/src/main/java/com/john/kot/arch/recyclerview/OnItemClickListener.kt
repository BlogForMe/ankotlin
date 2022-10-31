package com.john.kot.arch.recyclerview

import android.view.View

interface OnItemClickListener {
    /**
     * 点击事件
     * @param v
     * @param position
     */
    fun onItemClick(v: View?, position: Int)
}