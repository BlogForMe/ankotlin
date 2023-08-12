package com.kot.arch.recyclerview.multitype.visit

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * ClassName:      BaseViewHolder
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/23
 * UpdateUser:     zh
 * UpdateDate:     2023/4/23
 * UpdateRemark:   Modify the description
 */

abstract class BaseViewHolder<in Model>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(model: Model)
}