package com.john.kot.viewGroup

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityViewGroupBinding
import com.john.kot.viewGroup.view.HistoryFlowLayout

class ViewGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var itemTextView = LayoutInflater.from(this).inflate(R.layout.item_textview, null)
//        val historyFlowLayout = HistoryFlowLayout(this)

//        for (index in 0 until 5){
//            val textView = TextView(this)
//            textView.textSize = 20f
//            textView.text = " 历史记录 $index"
//            binding.flowLayout.addView(textView)
//        }
    }


}