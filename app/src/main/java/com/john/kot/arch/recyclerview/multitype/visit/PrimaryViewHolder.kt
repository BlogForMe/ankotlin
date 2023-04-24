package com.john.kot.arch.recyclerview.multitype.visit

import android.view.View
import android.widget.TextView
import com.john.kot.R

/**
 *
 * ClassName:      PrimaryViewHolder
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/23
 * UpdateUser:     zh
 * UpdateDate:     2023/4/23
 * UpdateRemark:   Modify the description
 */

class PrimaryViewHolder(itemView: View) : BaseViewHolder<Item>(itemView) {
    override fun bind(model: Item) = with(itemView) {
        with(model) {
            findViewById<TextView>(R.id.txt_name).text = name
            findViewById<TextView>(R.id.txt_type).text = type
        }
    }
}

class SecondaryViewHolder(itemView: View) : BaseViewHolder<Item>(itemView) {
    override fun bind(model: Item) = with(itemView) {
        with(model) {
            findViewById<TextView>(R.id.txt_name).text = name
            findViewById<TextView>(R.id.txt_name).visibility = View.GONE
            findViewById<TextView>(R.id.txt_type).text = type
        }
    }
}

class TertiaryViewHolder(itemView: View) : BaseViewHolder<Item>(itemView) {
    override fun bind(model: Item) = with(itemView) {
        with(model) {
            findViewById<TextView>(R.id.txt_name).text = name
            findViewById<TextView>(R.id.txt_type).text = type
        }
    }
}