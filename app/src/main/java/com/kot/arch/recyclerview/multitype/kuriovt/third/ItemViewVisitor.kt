package com.kot.arch.recyclerview.multitype.kuriovt.third

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kot.arch.recyclerview.multitype.kuriovt.second.Article
import com.kot.arch.recyclerview.multitype.kuriovt.second.Canvas
import com.kot.arch.recyclerview.multitype.kuriovt.second.Episode
import com.kot.arch.recyclerview.multitype.kuriovt.second.FeedContent

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
    fun visit(article: Article): ArticleItemView
    fun visit(canvas: Canvas): CanvasItemView
    fun visit(episode: Episode): EpisodeItemView
}