package com.john.kot.arch.recyclerview.multitype.kuriovt.third

import android.view.View
import android.widget.TextView
import com.john.kot.R
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.BaseViewHolder
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.Episode

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

class EpisodeTextOnlyViewHolder(val view: View) : BaseViewHolder<Episode>(view) {
    override fun bind(model: Episode) {
        (view.findViewById<TextView>(R.id.txt_name)).text = model.title
    }
}