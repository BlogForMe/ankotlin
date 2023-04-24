package com.john.kot.arch.recyclerview.multitype.kuriovt.third

/**
 *
 * ClassName:      BaseItemView
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

abstract class BaseItemView<I : FeedContent>(private val item: I) {
    abstract fun layoutResource(layoutType: String): Int
}