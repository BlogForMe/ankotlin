/*
* Copyright 2013 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.kot.arch.recyclerview

import android.graphics.Typeface
import android.os.Bundle
import android.text.BoringLayout
import android.text.TextPaint
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.util.window.util.dp
import com.android.util.window.util.getScreenWidth
import com.john.kot.R
import com.john.kot.databinding.ActivityMainBinding


/**
 * A simple launcher activity containing a summary sample description, sample log and a custom
 *
 *
 * For devices with displays with a width of 720dp or greater, the sample log is always visible,
 * on other devices it's visibility is controlled by an item on the Action Bar.
 */
class MainActivityApp : AppCompatActivity() {
    val TAG = "MainActivityApp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = "100"

        binding.rmTv.text = text
        binding.root.viewTreeObserver.addOnGlobalLayoutListener {
            val width = binding.rmTv.measuredWidth
            Log.i(TAG, "globalLayoutListener width: $width")
        }

//        val measureText = binding.rmTv.paint.measureText(text)
//        val measureText = textview.paint.measureText(text)
//        Log.i(TAG, "TextView measureText: $measureText")

        Log.i(
            TAG,
            "getItemPadding: ${getScreenWidth()}  AmountTextLength ${
                getTextLength(
                    Typeface.DEFAULT,
                    text
                )
            }"
        )

//        Log.i(TAG, "onCreate: getTextWidth ${getTextWidth(text)}")
        Log.i(TAG, "onCreate: getTextLength ${getTextLength(Typeface.DEFAULT, text)}")

        Log.i(
            TAG,
            "onCreate: getTextViewLength ${getTextViewLength(Typeface.DEFAULT, text, binding.rmTv)}"
        )

        val paint = TextPaint().apply {
            typeface = Typeface.DEFAULT
            textSize = 12f.dp
        }

        val desiredWidth = BoringLayout.getDesiredWidth(text, paint)
        Log.i(TAG, "desiredWidth :$desiredWidth")



        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            val fragment = RecyclerViewFragment()
            transaction.replace(R.id.sample_content_fragment, fragment)
            transaction.commitAllowingStateLoss()
        }
        val density = resources.displayMetrics.density
//        Log.i(TAG, "onCreate: density ${density} 2dp ${2f.dp}")

    }
}