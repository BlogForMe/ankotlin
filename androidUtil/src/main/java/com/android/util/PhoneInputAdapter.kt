package com.android.util

import android.graphics.Color
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.android.util.R

class PhoneInputAdapter(layoutResId: Int, data: List<String>?) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: String?) {

        if (item == "<-") {
            DrawableUtil.setDrawableLeft(
                helper?.getView<TextView>(R.id.tv_phone_input),
                helper?.itemView?.context?.getDrawable(R.drawable.ic_caculator_back)
            )
        } else if (item == "确认") {
            helper?.itemView?.setBackgroundColor(Color.parseColor("#fef3d5"))
            helper?.setTextColor(R.id.tv_phone_input, Color.parseColor("#FAC742"))
            helper?.setText(R.id.tv_phone_input, item)
        } else {
            helper?.setText(R.id.tv_phone_input, item)
        }
    }
}