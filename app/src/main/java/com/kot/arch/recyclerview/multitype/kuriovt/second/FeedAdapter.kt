package com.kot.arch.recyclerview.multitype.kuriovt.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * ClassName:      FeedAdapter
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

class FeedAdapter(private val visitor: ViewHolderVisitor = ViewHolderLayoutVisitor()) :
    RecyclerView.Adapter<BaseViewHolder<FeedContent>>() {

    private val items = mutableListOf<FeedItem>()

//    init {
    // Set dummy data to show the feed items
//        setList(Dummy.items)
//    }

    fun setList(items: List<FeedItem>) {
        if (this.items.isNotEmpty()) this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        val feedItem = items[position]
        return feedItem.content.accept(visitor, feedItem.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<FeedContent> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return visitor.create(view, viewType) ?: DefaultViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<FeedContent>, position: Int) {
        holder.bind(items[position].content)
    }
}