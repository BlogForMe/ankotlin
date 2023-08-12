package com.kot.viewgroup

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kot.databinding.ActivityViewGroupBinding

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

      fun1()
    }

    private fun fun1() {
        val mm: String? = null
        if (mm == null || mm.length == null) {
            return
        }
        Log.i("TAG", "onCreate: ")
    }


}