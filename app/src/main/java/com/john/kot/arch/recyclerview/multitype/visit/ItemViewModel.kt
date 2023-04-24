package com.john.kot.arch.recyclerview.multitype.visit

/**
 *
 * ClassName:      ItemViewModel
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/23
 * UpdateUser:     zh
 * UpdateDate:     2023/4/23
 * UpdateRemark:   Modify the description
 */

interface ItemViewModel {
    fun type(viewHolderTypeFactory: ViewHolderTypeFactory): Int
}