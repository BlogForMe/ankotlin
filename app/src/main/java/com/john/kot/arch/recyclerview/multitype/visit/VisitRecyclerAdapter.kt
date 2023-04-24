package com.john.kot.arch.recyclerview.multitype.visit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * ClassName:      VisitRecyclerAdapter
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/23
 * UpdateUser:     zh
 * UpdateDate:     2023/4/23
 * UpdateRemark:   Modify the description
 * https://medium.com/@slarsoncreative/creating-a-multiple-view-type-recyclerview-using-the-visitor-pattern-1184d8732167
 */

class VisitRecyclerAdapter : RecyclerView.Adapter<BaseViewHolder<Item>>() {

    private val typeFactory: ViewHolderTypeFactory = ViewHolderTypeFactoryImp()

    private val items = mutableListOf<Item>()

    fun setList(list: List<Item>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type(typeFactory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> {
        return typeFactory.create(
            LayoutInflater
                .from(parent.context)
                .inflate(viewType, parent, false), viewType
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        holder.bind(items[position])
    }
}