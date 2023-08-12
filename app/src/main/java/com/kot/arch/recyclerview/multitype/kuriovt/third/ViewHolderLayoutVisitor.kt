package com.kot.arch.recyclerview.multitype.kuriovt.third

import android.view.View
import com.john.kot.arch.recyclerview.multitype.kuriovt.second.*

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

class ViewHolderLayoutVisitor(private val visitor: ItemViewVisitor = ItemViewLayoutVisitor()) :
    ViewHolderVisitor {

    override fun create(parent: View, viewType: Int): BaseViewHolder<FeedContent>? {
        val viewHolder = visitor.data(parent)[viewType]
        return viewHolder as? BaseViewHolder<FeedContent>
    }

    override fun visit(article: Article, layout: String): Int {
        return visitor.visit(article).layoutResource(layout)
    }

    override fun visit(canvas: Canvas, layout: String): Int {
        return visitor.visit(canvas).layoutResource(layout)
    }

    override fun visit(episode: Episode, layout: String): Int {
        return visitor.visit(episode).layoutResource(layout)
    }
}