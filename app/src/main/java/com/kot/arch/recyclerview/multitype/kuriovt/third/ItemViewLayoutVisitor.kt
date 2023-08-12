package com.kot.arch.recyclerview.multitype.kuriovt.third

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.Article
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.Canvas
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.Episode
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.FeedContent

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

    override fun visit(article: Article): ArticleItemView {
        return ArticleItemView(article)
    }

    override fun visit(canvas: Canvas): CanvasItemView {
        return CanvasItemView(canvas)
    }

    override fun visit(episode: Episode): EpisodeItemView {
        return EpisodeItemView(episode)
    }
}