package com.kot.anim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kot.R


class MoveViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_view)

//        button2.setOnClickListener {
//            ObjectAnimator.ofFloat(textView,"translationX",200f).apply {
////            ObjectAnimator.ofFloat(textView,"translationY",100f).apply {
//                duration = 2000;
//                start()
//            }
//        }
//
//        button3.setOnClickListener {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////                val path = Path().apply {
////                    arcTo(0f, 0f, 1000f, 1000f, 270f, -180f, true)
////                }
//                val path = Path()
//                path.lineTo(0.25f, 0.25f)
//                path.moveTo(0.25f, 0.5f)
//                path.lineTo(1f, 1f)
//
////                val path = PathInterpolator(R.anim.pathinterpolator_object)
//                val pathInterpolator = PathInterpolator(path)
//                val animation = ObjectAnimator.ofFloat(textView2, "translationX", 100f).apply {
//                    interpolator = pathInterpolator
//                    start()
//                }
//
//
//            }
//        }
    }

    override fun finish() {
        super.finish()
    }
}
