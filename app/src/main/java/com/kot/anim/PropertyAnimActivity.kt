package com.kot.anim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kot.R

class PropertyAnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_property)

//        button.setOnClickListener {
////            valueAnimBase()
//            valueAnimUse(R.animator.property_anim_int) //跑完没看到按钮动
//        }
//
//        bt_anim.setOnClickListener {
//            propertyChange()
//        }

    }

//    private fun valueAnimUse(xmlAnimRes:Int){
//        val animate= AnimatorInflater.loadAnimator(this,xmlAnimRes)
//        animate.setTarget(tv_move_me)
//        animate.start()
//    }
//
//    private fun valueAnimBase() {
//        val anim = ValueAnimator.ofInt(0, 3)
//        // ofInt（）作用有两个
//        // 1. 创建动画实例
//        // 2. 将传入的多个Int参数进行平滑过渡:此处传入0和1,表示将值从0平滑过渡到1
//        // 如果传入了3个Int参数 a,b,c ,则是先从a平滑过渡到b,再从b平滑过渡到C，以此类推
//        // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置，即默认设置了如何从初始值 过渡到 结束值
//        // 关于自定义插值器我将在下节进行讲解
//        // 下面看看ofInt()的源码分析 ->>关注1
//
//
//        // 步骤2：设置动画的播放各种属性
//        anim.setDuration(500);
//        // 设置动画运行的时长
//
//        anim.setStartDelay(500);
//        // 设置动画延迟播放时间
//
//        anim.setRepeatCount(0);
//        // 设置动画重复播放次数 = 重放次数+1
//        // 动画播放次数 = infinite时,动画无限重复
//
//        anim.setRepeatMode(ValueAnimator.RESTART);
//        // 设置重复播放动画模式
//        // ValueAnimator.RESTART(默认):正序重放
//        // ValueAnimator.REVERSE:倒序回放
//
//        // 步骤3：将改变的值手动赋值给对象的属性值：通过动画的更新监听器
//        // 设置 值的更新监听器
//        // 即：值每次改变、变化一次,该方法就会被调用一次
//        anim.addUpdateListener {
//            val currentValue = it.getAnimatedValue()
//            Timber.i("currentValue  $currentValue")
//            // 步骤4：将改变后的值赋给对象的属性值，下面会详细说明
////            View.set
//
//        }
//        anim.start()
//    }
//
//
//    fun propertyChange(){
//        // 步骤1：设置属性数值的初始值 & 结束值
//        val valueAnimator = ValueAnimator.ofInt(bt_anim.layoutParams.width,500)
//        // 初始值 = 当前按钮的宽度，此处在xml文件中设置为150
//        // 结束值 = 500
//        // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置
//        // 即默认设置了如何从初始值150 过渡到 结束值500
//
//        // 步骤2：设置动画的播放各种属性
//        valueAnimator.setDuration(2000)
//        // 设置动画运行时长:1s
//
//// 步骤3：将属性数值手动赋值给对象的属性:此处是将 值 赋给 按钮的宽度
//        // 设置更新监听器：即数值每次变化更新都会调用该方法
//        valueAnimator.addUpdateListener {
//            val currentValue = it.animatedValue
//            // 获得每次变化后的属性值
//
//            Timber.i("currentValue  $currentValue")
//
//            bt_anim.layoutParams.width = currentValue as Int;
//
//            // 每次值变化时，将值手动赋值给对象的属性
//            // 即将每次变化后的值 赋 给按钮的宽度，这样就实现了按钮宽度属性的动态变化
//
//// 步骤4：刷新视图，即重新绘制，从而实现动画效果
//            bt_anim.requestLayout()
//        }
//        valueAnimator.start()
//    }
}
