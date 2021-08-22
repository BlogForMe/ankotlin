package com.john.kot

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.android.util.TimeCountUtil
import com.john.kot.R
import kotlinx.android.synthetic.main.activity_detail_live.*
import timber.log.Timber

class DetailLiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_live)
        bt_show.setOnClickListener {
            main_palying.setContentColor(Color.parseColor("#4e6550"))
        }

        var countUtil = TimeCountUtil(handler)
        countUtil.startSecond()
    }


    var handler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val timeTxt = msg.obj.toString()
//            if (tvTime != null) {
//                tvTime.setText("正在进行检测 " + timeTxt + "秒")
//                if ("59" == timeTxt) {
////                    mListener.scanTimeOut();
//                }
            Timber.i("timeTxt $timeTxt")
            }
//        }
    }
}