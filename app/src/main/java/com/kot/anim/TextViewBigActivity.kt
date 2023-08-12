package com.kot.anim

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.android.util.window.util.getScreenWidth
import com.kot.R
import com.kot.databinding.ActivityTextViewBigBinding
import com.kot.util.SpanStringUtils.contactIndexBuffer
import kotlin.math.abs

/**
 * Text
 */
class TextViewBigActivity : AppCompatActivity() {
    val TAG = "TextViewBigActivity"
    val binding by viewBinding(ActivityTextViewBigBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view_big)
        binding.tvCsPhoneShow.setOnClickListener {
//            Log.i(TAG, "onCreate:  ${maxWidthLine("aa bb ccc dd")}")
//            Log.i(TAG, "onCreate:  ${twoLineTextWidth(Paint(), "My RewardsMy2 Reward3 rewards4")}")
            Log.i(TAG, "onCreate:  ${twoLineTextWidth(Paint(), "My Reward")}")

        }

//        tv_cs_phone_show.setOnClickListener {
////            anim(R.anim.view_anim_scale_change_bigger)
//            it.setBackgroundResource(R.drawable.bg_home_ble_check)
//            AnimViewUtil.startAnim(tv_cs_phone_show,R.anim.view_anim_scale_change_bigger)
//        }
    }

//    private fun  anim(resAnim:Int){
//        val translateAnimation = AnimationUtils.loadAnimation(this,resAnim)
//        tv_cs_phone_show.startAnimation(translateAnimation)
//    }

    private fun twoLineTextWidth(paint: Paint, str: String): Float {
        val array = str.split("\\s".toRegex())
        var maxTextWidth = measureTextWith(paint, array[0])
        var minAbsWidth = getScreenWidth() / 3f
        for (i in 0 until array.size - 1) {
            val line1Width = measureTextWith(
                paint, array.joinToString(separator = "  ", limit = i + 1, truncated = "")
            )
            val line2Width = measureTextWith(paint, contactIndexBuffer(i + 1, array))

            val part1 = array.joinToString(separator = " ", limit = i + 1, truncated = "")
            val part2 = contactIndexBuffer(i + 1, array)
            Log.d(TAG, "i: $i twoLineTextWidth: part1: ${part1} part2:  ${part2}")

            if (abs(line2Width - line1Width) < minAbsWidth) {
                if (line2Width - line1Width < 0) {
                    minAbsWidth = line2Width - line1Width
                    maxTextWidth = line1Width
                    Log.d(
                        TAG,
                        "twoLineTextWidth result: ${
                            array.joinToString(
                                separator = " ",
                                limit = i,
                                truncated = ""
                            )
                        }"
                    )
                } else {
                    maxTextWidth = line2Width
                    Log.d(TAG, "twoLineTextWidth: ${contactIndexBuffer(i + 1, array)}")
                }
            }
        }
        return maxTextWidth
    }


    private fun measureTextWith(paint: Paint, text: CharSequence): Float {
        return paint.measureText(text.toString())
    }
}
