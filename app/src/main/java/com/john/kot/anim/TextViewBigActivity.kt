package com.john.kot.anim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.android.util.AnimViewUtil
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_text_view_big.*
import kotlinx.android.synthetic.main.activity_view_anim.*

/**
 * Text
 */
class TextViewBigActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view_big)

        tv_cs_phone_show.setOnClickListener {
//            anim(R.anim.view_anim_scale_change_bigger)
            it.setBackgroundResource(R.drawable.bg_home_ble_check)
            AnimViewUtil.startAnim(tv_cs_phone_show,R.anim.view_anim_scale_change_bigger)
        }
    }

//    private fun  anim(resAnim:Int){
//        val translateAnimation = AnimationUtils.loadAnimation(this,resAnim)
//        tv_cs_phone_show.startAnimation(translateAnimation)
//    }
}
