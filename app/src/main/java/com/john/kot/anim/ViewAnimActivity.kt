package com.john.kot.anim

import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_view_anim.*

/**
 * https://blog.csdn.net/carson_ho/article/details/72827747
 *
 */
class ViewAnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_anim)
        button.setOnClickListener {
            anim(R.anim.view_anim_translate) //平移动画
//            anim(R.anim.view_anim_scale)   //缩放动画
//            anim(R.anim.view_anim_rotate)  // rotate
//              anim(R.anim.view_anim_alpha)
//            alphaAnimUseCode()
//            anim(R.anim.view_anim_combied)

        }

        button1.setOnClickListener {
            val intent = Intent(this,MoveViewActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.activity_anim_enter,R.anim.activity_anim_exit)
        }
    }

    private fun  anim(resAnim:Int){
        val translateAnimation = AnimationUtils.loadAnimation(this,resAnim)
        textView5.startAnimation(translateAnimation)
    }

    fun alphaAnimUseCode(){
        val alphaAnimation = AlphaAnimation(1f,0f)
        alphaAnimation.duration = 3000
        textView5.startAnimation(alphaAnimation)
    }


}
