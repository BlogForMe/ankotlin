package com.john.kot.ui.scroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.john.kot.R
import com.john.kot.databinding.ActivityScrollViewBinding
import com.john.kot.util.viewBinding
import java.lang.RuntimeException

class ScrollViewActivity : AppCompatActivity() {
    val binding by viewBinding(ActivityScrollViewBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_scroll_view)
        binding.scrollToBtn.setOnClickListener {
//            binding.scrollToBtn.scrollTo(0, -100)
//            binding.scrollView.scrollTo(0, 500)
            getImpl("3")
        }

        binding.scrollByBtn.setOnClickListener {
            binding.scrollByBtn.scrollBy(0, -100);
        }
    }



    private fun getImpl(stringExtra: String?): String {
        lateinit var rfidTerminalI18n: String
        try {
            rfidTerminalI18n = if (stringExtra == "0") {
                "1"
            } else if (stringExtra == "1") {
               "2"
            } else {
                throw RuntimeException("Terminal impl init failed")
            }
        } catch (e: RuntimeException) {
            finish()
        }
        return rfidTerminalI18n
    }
}