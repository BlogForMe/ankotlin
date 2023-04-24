package com.john.kot.arch.recyclerview.multitype.kuriovt.third

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * ClassName:      ItemViewVisitor
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

interface ItemViewVisitor {
    fun data(itemView: View): SparseArray<RecyclerView.ViewHolder>
    fun visitDefault(feedContent: FeedContent): DefaultItemView
    fun visit(article: LayoutFactory.Article): ArticleItemView
    fun visit(canvas: LayoutFactory.Canvas): CanvasItemView
    fun visit(episode: LayoutFactory.Episode): EpisodeItemView
}