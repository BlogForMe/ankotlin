package com.john.kot.arch.recyclerview

import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.util.window.util.dp
import com.android.util.window.util.getScreenWidth

/**
 *
 * ClassName:      GridSpaceItemDecoration
 * Description:    Description
 * Author:         yangdong
 * CreateDate:     2021/1/20 11:31 AM
 * UpdateUser:
 * UpdateDate:     2021/1/20 11:31 AM
 * UpdateRemark:   Modify the description
 */


class ItemDecoration(
    private val spanCount: Int,
    private val rowSpacing: Int,
    private val columnSpacing: Int
) : RecyclerView.ItemDecoration() {

    val TAG = "ItemDecoration"

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val position = parent.getChildAdapterPosition(view) // 获取view 在adapter中的位置。
        val column = position % spanCount; // view 所在的列

        outRect.left = column * columnSpacing / spanCount; // column * (列间距 * (1f / 列数))
        outRect.right =
            columnSpacing - (column + 1) * columnSpacing / spanCount; // 列间距 - (column + 1) * (列间距 * (1f /列数))


        // 如果position > 行数，说明不是在第一行，则不指定行高，其他行的上间距为 top=mRowSpacing
        if (position >= spanCount) {
            outRect.top = rowSpacing; // item top
        }
    }
}

class ItemTransferAmount(val padding: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) {
            return
        }
//        if (position == 0) {
//            outRect.set(16.dp, 0, padding, 0)
//        } else {
        outRect.set(0, 0, padding, 0)
//        }
    }
}

const val COUNT_ITEM_AMOUNT_TRANSFER = 5 // item amount

fun getItemPadding(
    amountList: List<String>,
    CurrencyUnit: String,
    typeface: Typeface,
): Int {
    val PAGE_MARING_EDGE = 16.dp // page left right margin
    val PADDING_ITEM_TEXT = 10.dp // textview left right padding
    var list = amountList
    if (list.size > COUNT_ITEM_AMOUNT_TRANSFER) {
        list = list.subList(0, COUNT_ITEM_AMOUNT_TRANSFER)
    }
    val txtStr = StringBuilder()
    list.forEach {
        txtStr.append(it)
    }
    // 剩余的宽度/5 组建中间留白的个数
    var width =
        (getScreenWidth() - 2 * PAGE_MARING_EDGE - (getTextLength(
            typeface,
            txtStr.toString()
        ) + COUNT_ITEM_AMOUNT_TRANSFER * (2 * (PADDING_ITEM_TEXT + 1.dp) + getTextLength(
            typeface,
            CurrencyUnit
        )))) / (COUNT_ITEM_AMOUNT_TRANSFER - 1)
    if (width < 2.dp) {
        width = 2.dp
    }
    return width
}

fun getTextLength(typeface: Typeface, txt: String): Int {
    val paint = Paint()
    paint.typeface = typeface
    paint.textSize = 12.dp.toFloat()
    val textWidth = paint.measureText(txt)
    return textWidth.toInt()
}