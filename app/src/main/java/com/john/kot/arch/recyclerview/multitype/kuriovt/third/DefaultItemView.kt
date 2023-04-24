package com.john.kot.arch.recyclerview.multitype.kuriovt.third

import com.john.kot.arch.recyclerview.multitype.kuriovt.second.FeedContent
import com.john.kot.arch.recyclerview.multitype.kuriovt.third.LayoutFactory.Article.THUMBNAIL_TEXT_RIGHT


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

class DefaultItemView(feedContent: FeedContent) : BaseItemView<FeedContent>(feedContent) {
    override fun layoutResource(layoutType: String): Int {
        return when (layoutType.toInt()) {
            THUMBNAIL_TEXT_RIGHT -> LayoutFactory.Article.THUMBNAIL_TEXT_RIGHT
            else -> LayoutFactory.Article.DEFAULT
        }
    }
}