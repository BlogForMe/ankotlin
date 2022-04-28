package com.john.kot.anim

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.util.sysdialog.ItemPickDialog
import com.john.kot.R
import com.john.kot.anim.model.AnimServiceListener
import com.john.kot.databinding.ActivityLottieAnimBinding
import com.john.kot.ui.dialog.DialogShowFragment
import com.john.kot.ui.dialog.dArr
import com.john.kot.util.viewBinding

val animationUrl1 =
    "https://cdn.tngdigital.com.my/resource/2022/2/11/3ff2468a-29d3-4262-9396-79330ca46813.json"
val animationUrl2 =
    "https://cdn.tngdigital.com.my/resource/2022/1/24/07356ab6-4221-4ee6-bb4b-8d18e580a378.json"

class LottieAnimActivity : AppCompatActivity(), ItemPickDialog.ISelectListener {
    val binding by viewBinding(ActivityLottieAnimBinding::inflate)

    private val TAG = "LottieAnimActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animationView = binding.homeServiceImg

        lifecycle.addObserver(AnimServiceListener())

        binding.btDialogShow.setOnClickListener {
            ItemPickDialog.newInstance("请选择测量项",dArr).show(supportFragmentManager,"")
        }

        binding.btAnimShow.setOnClickListener {
            animationView.setFailureListener {
                animationView.setImageResource(R.drawable.ic_go_pinjam)
            }
            animationView.setAnimationFromUrl(animationUrl1)
            animationView.playAnimation()
            animationView.repeatCount = ValueAnimator.INFINITE
            animationView.backgroundTintMode
        }

        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                Log.i(TAG, "onAnimationStart: ")
            }

            override fun onAnimationEnd(animation: Animator?) {
                Log.i(TAG, "onAnimationEnd: ")
            }

            override fun onAnimationCancel(animation: Animator?) {
                Log.i(TAG, "onAnimationCancel: ")
            }

            override fun onAnimationRepeat(animation: Animator?) {
                Log.i(TAG, "onAnimationRepeat: ")
            }

        })
    }

    override fun getItemPosition(position: Int) {

    }

}