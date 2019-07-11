package com.john.ankotlin.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.john.ankotlin.R
import kotlinx.android.synthetic.main.activity_constraint.*

class ConstraintPlaceholderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
        bt_one.setOnClickListener {
            //            val iv = intArrayOf(R.id.iv_girl1)
//            group.referencedIds=iv
            group.visibility = View.VISIBLE
        }

        bt_two.setOnClickListener {
            val iv = intArrayOf(R.id.iv_girl2)
            group.visibility = View.INVISIBLE
        }
    }
}
