package com.kot.arch.recyclerview.multitype.visit

import android.view.View
import com.john.kot.arch.recyclerview.multitype.visit.Item.Companion.PRIMARY
import com.john.kot.arch.recyclerview.multitype.visit.Item.Companion.PRIMARY_VIEW
import com.john.kot.arch.recyclerview.multitype.visit.Item.Companion.SECONDARY
import com.john.kot.arch.recyclerview.multitype.visit.Item.Companion.SECONDARY_VIEW
import com.john.kot.arch.recyclerview.multitype.visit.Item.Companion.TERTIARY_VIEW

/**
 *
 * ClassName:      ViewHolderTypeFactoryImp
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/23
 * UpdateUser:     zh
 * UpdateDate:     2023/4/23
 * UpdateRemark:   Modify the description
 */

class ViewHolderTypeFactoryImp : ViewHolderTypeFactory {
    override fun create(parent: View, viewType: Int): BaseViewHolder<Item> {
        return when (viewType) {
            PRIMARY_VIEW -> PrimaryViewHolder(parent)
            SECONDARY_VIEW -> SecondaryViewHolder(parent)
            else -> TertiaryViewHolder(parent)
        }
    }

    override fun type(item: Item): Int {
        return when (item.type) {
            PRIMARY -> PRIMARY_VIEW
            SECONDARY -> SECONDARY_VIEW
            else -> TERTIARY_VIEW
        }
    }
}