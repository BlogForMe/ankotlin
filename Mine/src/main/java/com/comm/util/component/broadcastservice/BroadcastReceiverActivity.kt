package com.comm.util.component.broadcastservice

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.android.util.viewbind.viewBinding
import com.comm.util.R
import com.comm.util.databinding.ActivityBroadcastReceiverBinding

class BroadcastReceiverActivity : AppCompatActivity() {
    private var updateBr: UpdateBroadcastReceiver? = null
    private val downUrL = "http://116.62.149.166:8301/v2/open/version/download"
    val binding by viewBinding(ActivityBroadcastReceiverBinding::inflate)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)

        //点击发送普通广播
        binding.btBroadcast.setOnClickListener {
            val intent = Intent()
            intent.action = UpdateBroadcastReceiver.ACTION_UPDATE
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
//            intent.setPackage("com.comm.util")
//            sendBroadcast(intent)

        }

//        bt_go_second.setOnClickListener {
//            startActivity(Intent(this, SecondBroadCastActivity::class.java))
//        }


//        val intent = Intent()
//        intent.action = "com.broadcast.android"

//        bt_order_broadcast.setOnClickListener {
//            sendOrderedBroadcast(intent, null)
//        }
//
//        bt_local_broadcast.setOnClickListener {
//            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
//        }


        updateBr = UpdateBroadcastReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(UpdateBroadcastReceiver.ACTION_UPDATE)

//        registerReceiver(updateBr, intentFilter,RECEIVER_EXPORTED)
//        registerReceiver(updateBr, IntentFilter(Intent.ACTION_BATTERY_CHANGED)) //system broadcast
        LocalBroadcastManager.getInstance(this).registerReceiver(updateBr!!, intentFilter)
    }


    override fun onDestroy() {
        super.onDestroy()
        if (updateBr != null) {
            unregisterReceiver(updateBr)
        }
    }
}