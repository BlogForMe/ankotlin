package com.kot

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.john.kot.databinding.ActivityColorIntBinding

class ColorIntActivity : AppCompatActivity() {
    val TAG = "ColorIntActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityColorIntBinding.inflate(layoutInflater)

        setContentView(binding.root)
        com.kot.util.StatusBarCompat.compat(this, R.color.color_005ABE)


        binding.btClick.setOnClickListener {
//           val whilteint =resources.getColor(R.color.white)
//            Log.i(TAG, "onCreate: $whilteint")
            val color = ContextCompat.getColor(this, R.color.color_005ABE)
            Log.i(TAG, "onCreate color: $color")
            binding.tvText.visibility = View.GONE
        }
    }
}