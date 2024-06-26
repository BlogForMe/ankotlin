package com.comm.util.component.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.util.viewbind.viewBinding
import com.comm.util.R
import com.comm.util.databinding.ActivityCheckServiceBinding
import timber.log.Timber

/**
 * @author : John
 * @date : 2018/7/12
 * Service生命周期验证
 */
class CheckServiceActivity : AppCompatActivity() {
    private var mShouldUnbind = false

    val binding by viewBinding(ActivityCheckServiceBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val intent = Intent(this, ServiceLifeCycle::class.java)
        val intent = Intent("com.example.service.android14")
//        intent.putExtra(PARRAM, "CANS")
        intent.`package` = "com.comm.util"
        binding.btStartService.setOnClickListener { v: View? ->
            startService(intent)
        }
//        bt_stop_service.setOnClickListener {
//            stopService(intent)
//        }
//        bt_bind_service.setOnClickListener {
//            if (bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)) {
//                mShouldUnbind = true
//            } else {
//                Log.e(
//                    "MY_APP_TAG", "Error: The requested service doesn't " +
//                            "exist, or this client isn't allowed access to it."
//                )
//            }
//        }
//
//        bt_unbind_service.setOnClickListener {
//            unBindService()
//        }
//
//        bt_stop_myself.setOnClickListener {
//            mBlueService?.stopMySelf()
//        }
    }

    fun unBindService() {
        if (mShouldUnbind) {
            mServiceConnection.let {
                unbindService(it)
                mShouldUnbind = false
            }
        }
    }

    private var mBlueService: ServiceLifeCycle? = null
    var mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            mBlueService = (service as ServiceLifeCycle.LocalBinder).service
            Timber.d("onServiceConnected(ComponentName name, IBinder service)")
        }

        override fun onServiceDisconnected(name: ComponentName) {
            Timber.d("onServiceDisconnected(ComponentName name)")
        }
    }

    override fun onDestroy() {
        stopService(intent)
        unBindService()
        super.onDestroy()
    }

    companion object {
        const val PARRAM = "PARAM01"
    }
}