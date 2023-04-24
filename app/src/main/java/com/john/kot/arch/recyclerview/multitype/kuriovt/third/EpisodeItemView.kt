package com.john.kot.arch.recyclerview.multitype.kuriovt.third

import com.john.kot.arch.recyclerview.multitype.kuriovt.second.Episode
import com.john.kot.arch.recyclerview.multitype.kuriovt.third.LayoutFactory.Episode.TEXT_ONLY

/**
 *
 * ClassName:      EpisodeItemView
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/4/24
 * UpdateUser:     zh
 * UpdateDate:     2023/4/24
 * UpdateRemark:   Modify the description
 */

class EpisodeItemView(podcast: Episode) : BaseItemView<Episode>(podcast) {
    override fun layoutResource(layoutType: String): Int {
        return when (layoutType.toInt()) {
            TEXT_ONLY -> LayoutFactory.Episode.TEXT_ONLY
            else -> LayoutFactory.Episode.DEFAULT
        }
    }
}