package com.kot.arch.recyclerview.multitype.kuriovt.second

/**
 *
 * ClassName:      Episode
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

data class Episode(override val title: String, val author: String, val imageUrl: String) :
    FeedContent(title) {
    override fun accept(
        viewHolderVisitor: ViewHolderVisitor,
        layout: String,
    ): Int {
        return viewHolderVisitor.visit(this, layout)
    }
}