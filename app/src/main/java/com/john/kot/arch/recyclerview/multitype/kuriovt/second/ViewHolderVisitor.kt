package com.john.kot.arch.recyclerview.multitype.kuriovt.second

import android.view.View

/**
 *
 * ClassName:      ViewHolderVisitor
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

interface ViewHolderVisitor {
    fun create(parent: View, viewType: Int): BaseViewHolder<FeedContent>?
    fun visit(article: Article, layout: String): Int
    fun visit(article: Canvas, layout: String): Int
    fun visit(episode: Episode, layout: String): Int
}