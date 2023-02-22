package com.android.util

import androidx.annotation.VisibleForTesting

/**
 *
 * ClassName:      _Math
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/2/15
 * UpdateUser:     zh
 * UpdateDate:     2023/2/15
 * UpdateRemark:   Modify the description
 */

@VisibleForTesting
fun maxLength(goPlusWidth: Float, rewardWidth: Float, eshopWidth: Float): Float {
    var max = goPlusWidth
    if (rewardWidth > max) {
        max = rewardWidth
    }
    if (eshopWidth > max) {
        max = eshopWidth
    }
    return max
}