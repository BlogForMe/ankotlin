package com.john.kot.arch.recyclerview.multitype.kuriovt.third

import com.john.kot.arch.recyclerview.multitype.kuriovt.third.LayoutFactory.Canvas.BIG_THUMBNAIL


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

class CanvasItemView(canvas: LayoutFactory.Canvas) : BaseItemView<LayoutFactory.Canvas>(canvas) {
    override fun layoutResource(layoutType: String): Int {
        return when (layoutType) {
            BIG_THUMBNAIL -> LayoutFactory.Canvas.BIG_THUMBNAIL
            else -> LayoutFactory.Canvas.DEFAULT
        }
    }
}