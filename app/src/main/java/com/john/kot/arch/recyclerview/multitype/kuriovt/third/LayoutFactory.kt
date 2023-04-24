package com.john.kot.arch.recyclerview.multitype.kuriovt.third

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.john.kot.R

/**
 *
 * ClassName:      LayoutFactory
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

object LayoutFactory {
    object Article : FeedContent("Article") {
        val DEFAULT = R.layout.viewholder_article_default
        val THUMBNAIL_TEXT_RIGHT = R.layout.viewholder_article_thumbnail_text_right
        override fun accept(viewHolderVisitor: ViewHolderVisitor, layout: String): Int {
            return viewHolderVisitor.visit(this, layout)
        }
    }

    object Canvas : FeedContent("Canvas") {
        val DEFAULT = R.layout.viewholder_canvas_default
        val BIG_THUMBNAIL = R.layout.viewholder_canvas_big_thumbnail
        override fun accept(viewHolderVisitor: ViewHolderVisitor, layout: String): Int {
            return viewHolderVisitor.visit(this, layout)
        }
    }

    object Episode : FeedContent("Episode") {
        val DEFAULT = R.layout.viewholder_episode_default
        val TEXT_ONLY = R.layout.viewholder_episode_text_only
        override fun accept(viewHolderVisitor: ViewHolderVisitor, layout: String): Int {
            return viewHolderVisitor.visit(this, layout)
        }
    }

    val DEFAULT = R.layout.viewholder_default

    fun layouts(view: View): SparseArray<RecyclerView.ViewHolder> =
        SparseArray<RecyclerView.ViewHolder>().also {
            it.append(Article.DEFAULT, ArticleViewHolder(view))
            it.append(Article.THUMBNAIL_TEXT_RIGHT, ArticleThumbnailTextRightViewHolder(view))
            it.append(Canvas.DEFAULT, CanvasViewHolder(view))
            it.append(Canvas.BIG_THUMBNAIL, CanvasBigThumbnailViewHolder(view))
            it.append(Episode.DEFAULT, EpisodeViewHolder(view))
            it.append(Episode.TEXT_ONLY, EpisodeTextOnlyViewHolder(view))
            it.append(DEFAULT, DefaultViewHolder(view))
        }
}