package com.kot.ui.scroll

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityScrollViewBinding

class ScrollViewActivity : AppCompatActivity() {
    val binding by viewBinding(ActivityScrollViewBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.scrollToBtn.setOnClickListener {
//            binding.scrollToBtn.scrollTo(0, -100)
//            binding.scrollView.scrollTo(0, 500)
            getImpl("3")
        }

        binding.scrollByBtn.setOnClickListener {
            binding.scrollByBtn.scrollBy(0, -100);
        }
        binding.tvTextEllipsize.setLines(1)
        binding.tvTextEllipsize.ellipsize = TextUtils.TruncateAt.END
        binding.tvTextEllipsize.text="val binding by viewBinding(ActivityScrollViewBinding::inflate)"
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