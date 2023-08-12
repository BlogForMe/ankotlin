package com.kot.arch.recyclerview.multitype.kuriovt.third

import android.view.View
import android.widget.TextView
import com.kot.R
import com.kot.arch.recyclerview.multitype.kuriovt.second.BaseViewHolder
import com.kot.arch.recyclerview.multitype.kuriovt.second.Canvas

/**
 *
 * ClassName:      ArticleViewHolder
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

class CanvasBigThumbnailViewHolder(val view: View) : BaseViewHolder<Canvas>(view) {
    override fun bind(model: Canvas) {
        (view.findViewById<TextView>(R.id.txt_name)).text = model.title
    }
}