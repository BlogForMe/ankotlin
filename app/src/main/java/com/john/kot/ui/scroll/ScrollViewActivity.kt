package com.john.kot.ui.scroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_scroll_view.*

class ScrollViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)

        scroll_to_btn.setOnClickListener {
            layout.scrollTo(-60,-100)
        }

        scroll_by_btn.setOnClickListener {
            layout.scrollBy(-60, -100);
        }
    }
}