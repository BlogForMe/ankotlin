package com.kot.arch.recyclerview.multitype.kuriovt.third

import com.kot.arch.recyclerview.multitype.kuriovt.second.Canvas
import com.kot.arch.recyclerview.multitype.kuriovt.third.LayoutFactory.Canvas.BIG_THUMBNAIL


/**
 *
 * ClassName:      CanvasItemView
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

class CanvasItemView(canvas: Canvas) : BaseItemView<Canvas>(canvas) {
    override fun layoutResource(layoutType: String): Int {
        return when (layoutType.toInt()) {
            BIG_THUMBNAIL -> BIG_THUMBNAIL
            else -> LayoutFactory.Canvas.DEFAULT
        }
    }
}