package com.kot.arch.recyclerview.multitype.normal

/**
 *
 * ClassName:      BasicRecyclerAdapter
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/23
 * UpdateUser:     zh
 * UpdateDate:     2023/4/23
 * UpdateRemark:   Modify the description
 */

//class BasicRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    private val items = mutableListOf<Item>()
//
//    fun setList(list: List<Item>) {
//        items.clear()
//        items.addAll(list)
//        notifyDataSetChanged()
//    }
//
//    /**
//     *   This will provide the onCreateViewHolder method with the appropriate
//     *   viewType for each item.
//     */
//    override fun getItemViewType(position: Int): Int {
//        return when(items[position].type) {
//            "Primary" -> 0
//            "Secondary" -> 1
//            else -> 2
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when (viewType) {
//            0 -> {
//                PrimaryViewHolder(
//                    LayoutInflater.from(parent.context)
//                        .inflate(R.layout.item_items_view, parent, false)
//                )
//            }
//            1 -> {
//                SecondaryViewHolder(
//                    LayoutInflater.from(parent.context)
//                        .inflate(R.layout.item_secondary_items_view, parent, false)
//                )
//            }
//            else -> {
//                TertiaryViewHolder(
//                    LayoutInflater.from(parent.context)
//                        .inflate(R.layout.item_tertiary_items_view, parent, false)
//                )
//            }
//        }
//    }
//
//    override fun getItemCount() = items.size
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (holder) {
//            is PrimaryViewHolder -> holder.apply {
//                name.text = items[position].name
//                type.text = items[position].type
//            }
//            is SecondaryViewHolder -> holder.apply {
//                secondaryName.text = items[position].name
//                secondaryType.text = items[position].type
//            }
//            is TertiaryViewHolder -> holder.apply {
//                tertiaryName.text = items[position].name
//                tertiaryType.text = items[position].type
//            }
//        }
//    }
//}
//class PrimaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    val name: TextView = itemView.txt_name
//    val type: TextView = itemView.txt_type
//}
//
//class SecondaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    val secondaryName: TextView = itemView.txt_name
//    val secondaryType: TextView = itemView.txt_type
//}
//
//class TertiaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    val tertiaryName: TextView = itemView.txt_name
//    val tertiaryType: TextView = itemView.txt_type
//}