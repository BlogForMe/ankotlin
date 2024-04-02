package com.kot.ui

import android.os.Bundle
import android.text.InputFilter
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityKeyBordBinding

// https://skyacer.github.io/2017/09/12/Android-Disable-Emoji-in-Edittext/
class KeyBordActivity : AppCompatActivity() {

    val binding by viewBinding(ActivityKeyBordBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.etText.filters = arrayOf(filters)

    }
    private val blockCharacterSet = "~#^|$%&*!";


    private val filter =
        InputFilter { source, start, end, dest, dstart, dend ->
            if (source != null && blockCharacterSet.contains("" + source)) {
                ""
            } else null
        }
}

var EMOJI_FILTER = InputFilter { source, start, end, dest, dstart, dend ->
    for (index in start until end) {
        val type = Character.getType(source[index])
        if (type == Character.SURROGATE.toInt()) {
            return@InputFilter ""
        }
    }
    null
}

val filters =
    InputFilter { source, _, _, _, _, _ ->
        source.filter {
            Character.getType(it) != Character.SURROGATE.toInt() && Character.getType(it) != Character.OTHER_SYMBOL.toInt()
        }
    }