package com.kot.arch.recyclerview.multitype.visit

import android.view.View

/**
 *
 * ClassName:      ViewHolderTypeFactory
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/23
 * UpdateUser:     zh
 * UpdateDate:     2023/4/23
 * UpdateRemark:   Modify the description
 */

interface ViewHolderTypeFactory {
    fun type(item: Item): Int
    fun create(parent: View, viewType: Int): BaseViewHolder<Item>
}