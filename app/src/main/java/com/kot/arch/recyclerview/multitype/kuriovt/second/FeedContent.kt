package com.kot.arch.recyclerview.multitype.kuriovt.second

/**
 *
 * ClassName:      FeedContent
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

abstract class FeedContent(open val title: String) {
    abstract fun accept(
        viewHolderVisitor: ViewHolderVisitor,
        layout: String,
    ): Int
}