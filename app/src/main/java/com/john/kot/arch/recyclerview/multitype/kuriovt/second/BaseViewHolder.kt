package com.john.kot.arch.recyclerview.multitype.kuriovt.second

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * ClassName:      BaseViewHolder
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

abstract class BaseViewHolder<in Model : FeedContent>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(model: Model)
}