package com.kot.ui

import android.os.Bundle
import android.text.InputFilter
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityKeyBordBinding


class KeyBordActivity : AppCompatActivity() {

    val binding by viewBinding(ActivityKeyBordBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.etText.filters = arrayOf(EMOJI_FILTER)

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