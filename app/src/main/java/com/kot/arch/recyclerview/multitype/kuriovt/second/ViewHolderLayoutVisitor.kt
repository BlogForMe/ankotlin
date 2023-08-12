package com.kot.arch.recyclerview.multitype.kuriovt.second

import android.view.View
import com.john.kot.R

/**
 *
 * ClassName:      ViewHolderLayoutVisitor
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

class ViewHolderLayoutVisitor : ViewHolderVisitor {
    override fun create(parent: View, viewType: Int): BaseViewHolder<FeedContent>? {
        return when (viewType) {
            R.layout.viewholder_article_default -> ArticleViewHolder(parent)
            R.layout.viewholder_canvas_default -> CanvasViewHolder(parent)
            R.layout.viewholder_episode_default -> EpisodeViewHolder(parent)
            else -> DefaultViewHolder(parent)
        } as? BaseViewHolder<FeedContent>
    }

    override fun visit(article: Article, layout: String): Int {
        // Render article layout resource based on layout type
//        if (layout != articleDefault)
//            return R.layout.viewholder_default

        return R.layout.viewholder_article_default
    }

    override fun visit(article: Canvas, layout: String): Int {
        // Render canvas layout resource based on layout type
//        if (layout != canvasDefault)
//            return R.layout.viewholder_default
        return R.layout.viewholder_canvas_default
    }

    override fun visit(episode: Episode, layout: String): Int {
        // Render episode layout resource based on layout type
//        if (layout != episodeDefault)
//            return R.layout.viewholder_default
        return R.layout.viewholder_episode_default
    }
}