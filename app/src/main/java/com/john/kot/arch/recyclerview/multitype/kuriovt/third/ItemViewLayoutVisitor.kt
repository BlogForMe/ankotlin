package com.john.kot.arch.recyclerview.multitype.kuriovt.third

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * ClassName:      ItemViewLayoutVisitor
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

class ItemViewLayoutVisitor : ItemViewVisitor {
    override fun data(itemView: View): SparseArray<RecyclerView.ViewHolder> {
        return LayoutFactory.layouts(itemView)
    }

    override fun visitDefault(feedContent: FeedContent): DefaultItemView {
        return DefaultItemView(feedContent)
    }

    override fun visit(article: LayoutFactory.Article): ArticleItemView {
        return ArticleItemView(article)
    }

    override fun visit(canvas: LayoutFactory.Canvas): CanvasItemView {
        return CanvasItemView(canvas)
    }

    override fun visit(episode: LayoutFactory.Episode): EpisodeItemView {
        return EpisodeItemView(episode)
    }
}