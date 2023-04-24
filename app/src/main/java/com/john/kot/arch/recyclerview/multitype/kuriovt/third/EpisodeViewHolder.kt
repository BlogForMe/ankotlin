package com.john.kot.arch.recyclerview.multitype.kuriovt.third

import android.view.View
import android.widget.TextView
import com.john.kot.R

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

class EpisodeViewHolder(val view: View) : BaseViewHolder<LayoutFactory.Article>(view) {
    override fun bind(model: LayoutFactory.Article) {
        (view.findViewById<TextView>(R.id.txt_name)).text = model.title
    }
}