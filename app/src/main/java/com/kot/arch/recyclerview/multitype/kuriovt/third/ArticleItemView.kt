package com.kot.arch.recyclerview.multitype.kuriovt.third

import com.john.kot.arch.recyclerview.multitype.kuriovt.second.Article

/**
 *
 * ClassName:      ArticleItemView
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */


class ArticleItemView(article: Article) : BaseItemView<Article>(article) {
    override fun layoutResource(layoutType: String): Int {
        return when (layoutType.toInt()) {
            LayoutFactory.Article.THUMBNAIL_TEXT_RIGHT -> LayoutFactory.Article.THUMBNAIL_TEXT_RIGHT
            else -> LayoutFactory.Article.DEFAULT
        }
    }
}