package com.kot.arch.recyclerview.multitype.visit

import com.kot.R

/**
 *
 * ClassName:      Item
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/23
 * UpdateUser:     zh
 * UpdateDate:     2023/4/23
 * UpdateRemark:   Modify the description
 */

data class Item(
    val name: String,
    val type: String,
) : ItemViewModel {
    override fun type(viewHolderTypeFactory: ViewHolderTypeFactory): Int {
        return viewHolderTypeFactory.type(this)
    }

    companion object {
        const val PRIMARY = "primary"
        const val SECONDARY = "secondary"
        const val TERTIARY = "tertiary"
        const val PRIMARY_VIEW = R.layout.item_items_view
        const val SECONDARY_VIEW = R.layout.item_secondary_items_view
        const val TERTIARY_VIEW = R.layout.item_tertiary_items_view
    }

}