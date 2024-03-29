package com.kot.arch.recyclerview.multitype.kuriovt.third

import android.view.View
import android.widget.TextView
import com.kot.R
import com.kot.arch.recyclerview.multitype.kuriovt.second.Article
import com.kot.arch.recyclerview.multitype.kuriovt.second.BaseViewHolder

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

class ArticleViewHolder(val view: View) : BaseViewHolder<Article>(view) {
    override fun bind(model: Article) {
        (view.findViewById<TextView>(R.id.txt_name)).text = model.title
    }
}