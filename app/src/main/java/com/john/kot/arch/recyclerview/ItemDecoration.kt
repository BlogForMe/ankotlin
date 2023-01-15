package com.john.kot.arch.recyclerview

import android.content.res.Resources
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.widget.TextView
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

val TAG = "ItemDecoration"

class ItemDecoration(
    private val spanCount: Int,
    private val rowSpacing: Int,
    private val columnSpacing: Int
) : RecyclerView.ItemDecoration() {


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
        when (position) {
            0 -> {
                outRect.set(16.dp, 0, padding, 0)
            }
            COUNT_ITEM_AMOUNT_TRANSFER.minus(1) -> {
                outRect.set(0, 0, 0, 0)
            }
            else -> {
                outRect.set(0, 0, padding, 0)
            }
        }
    }
}

const val COUNT_ITEM_AMOUNT_TRANSFER = 5 // item amount

fun getItemPadding(
    amountList: List<String>,
    currencyUnit: String,
    typeface: Typeface,
): Int {
    val PAGE_MARING_EDGE = 16f.dp // page left right margin
    val PADDING_ITEM_TEXT = 10f.dp // textview left right padding
    var list = amountList
    if (list.size > COUNT_ITEM_AMOUNT_TRANSFER) {
        list = list.subList(0, COUNT_ITEM_AMOUNT_TRANSFER)
    }
    val pageEdgeWidth = 2 * PAGE_MARING_EDGE
    val rmWidth = (COUNT_ITEM_AMOUNT_TRANSFER - 1) * (getTextLength(typeface, currencyUnit) + 2f.dp)
    val textPaddingWidth = COUNT_ITEM_AMOUNT_TRANSFER * (2f * PADDING_ITEM_TEXT)

    var textWidth = 0f
    list.forEach {
        textWidth += getTextLength(typeface, it)
    }

    // 剩余的宽度/5 组建中间留白的个数
    var widthPadding =
        (getScreenWidth() - pageEdgeWidth - rmWidth - textPaddingWidth - textWidth) / (COUNT_ITEM_AMOUNT_TRANSFER - 1)

//    LogUtils.d(TAG + " 2dp ${2f.sp} getScreenWidth() ${getScreenWidth()}")

//    if (widthPadding < 2f.dp) {
//        widthPadding = 2f.dp
//        LogUtils.d(TAG + "width < 2.dp" + widthPadding)
//    }

//    LogUtils.d("$TAG widthPadding $widthPadding pageEdgeWidth  $pageEdgeWidth   rmWidth $rmWidth  textPaddingWidth $textPaddingWidth textWidth $textWidth")
//    LogUtils.d("$TAG displayMetrics ${Resources.getSystem().displayMetrics}")
    return widthPadding.toInt()
}

fun getTextLength(typeface: Typeface, txt: String): Float {
    val paint = Paint()
    paint.typeface = typeface
    paint.textSize = 12f.dp

//    val rect = Rect()
//    paint.getTextBounds(txt, 0, txt.length, rect)
//    val textWidth = rect.width().toFloat()

    val textWidth = paint.measureText(txt)
//    LogUtils.d("$TAG $txt txtWidth :$textWidth")
    return textWidth
}

fun getTextViewLength(typeface: Typeface, txt: String, textView: TextView): Float {
//    val paint = Paint()
//    paint.typeface = typeface
//    paint.textSize = 12f.dp // 可以提出去

//    val rect = Rect()
//    paint.getTextBounds(txt, 0, txt.length, rect)
//    val textWidth = rect.width().toFloat()

//    val textWidth1 = paint.measureText(txt)
//    LogUtils.d("$TAG $txt textWidth1 :$textWidth1")

    textView.textSize = 12f
    val textWidth = textView.paint.measureText(txt)
//    LogUtils.d("$TAG $txt txtWidth :$textWidth")
    return textWidth
}