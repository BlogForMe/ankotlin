package com.kot.ui

import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.util.sysdialog.ItemPickDialog
import com.john.kot.R
import com.john.kot.ui.dialog.DialogShowFragment

class MeasureLearnActivity : AppCompatActivity(), ItemPickDialog.ISelectListener {
    val TAG = "MeasureLearnActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measure_learn)

//        val scale = getResources().getDisplayMetrics().density
        val s1 = "rewards"
        val s2 = "rewards\nrewards"


        val measureTextWiths1 = measureTextWith(s1)
        val measureTextWithss2 = measureTextWith(s2)
        Log.i(TAG, "measureTextWiths1: $measureTextWiths1  measureTextWithss2 $measureTextWithss2")

//        val rect1 = measureBoundWith(s1)
//        val rect2 = measureBoundWith(s2)
//        Log.i(TAG, "measureBoundWith1: ${rect1.width()} ${rect1.height()}  measureBoundWith2 ${rect2.width()} ${rect2.height()} ")

        for (i in 65 until 127) {
//            println(i.toChar())
            Log.i(TAG, " ${i.toChar()} ${measureTextWith(i.toChar().toString())}")
        }
    }

    override fun getItemPosition(position: Int) {
        DialogShowFragment.newInstance()
    }


    private fun measureTextWith(text: CharSequence): Int {
        return Paint().measureText(text.toString()).toInt()
    }

    private fun measureBoundWith(text: CharSequence): Rect {
        val paint = Paint()
        val bounds = Rect()
        paint.getTextBounds(text, 0, text.length, bounds)
        val height = bounds.height()
        val width = bounds.width()
        return bounds
    }


}
