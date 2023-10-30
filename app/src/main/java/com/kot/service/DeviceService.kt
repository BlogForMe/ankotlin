package com.kot.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.kot.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *
 * ClassName:      DeviceService
 * Description:    Description
 * Author:         zh
 * CreateDate:     2023/10/26
 * UpdateUser:     zh
 * UpdateDate:     2023/10/26
 * UpdateRemark:   Modify the description
 */

class DeviceService : Service() {

    private lateinit var deviceBroadcastReceiver: DeviceBroadcastReceiver
    private lateinit var mContext: Context
    private val TAG = "DeviceService"

    /** 标记服务是否启动 */
    private var serviceIsLive = false

    /** 唯一前台通知ID */
    private val NOTIFICATION_ID = 1000

    override fun onCreate() {
        super.onCreate()
        mContext = this
        //前台显示服务
        // 获取服务通知
        val notification: Notification = createForegroundNotification()

        Log.i(TAG, "onCreate: startForeground")
        //将服务置于启动状态 ,NOTIFICATION_ID指的是创建的通知的ID
        startForeground(NOTIFICATION_ID, notification)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        CoroutineScope(Dispatchers.Main).launch {
//            delay(1000L)//阻塞时间
//            receiverRegist()
//            Log.i(TAG, "onStartCommand: "/*+ intent?.getStringExtra("key")*/)
//        }
//         标记前台服务启动
        serviceIsLive = true
        return super.onStartCommand(intent, flags, startId)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun receiverRegist() {
        deviceBroadcastReceiver = DeviceBroadcastReceiver()
        val filter = IntentFilter()
        filter.addAction("deviceCall")
        registerReceiver(deviceBroadcastReceiver, filter, RECEIVER_NOT_EXPORTED)
    }


    /**
     * 创建前台服务通知
     */
    private fun createForegroundNotification(): Notification {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // 唯一的通知通道的id.
        val notificationChannelId = "notification_channel_id_01"

        // Android8.0以上的系统，新建消息通道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //用户可见的通道名称
            val channelName = "Foreground Service Notification"
            //通道的重要程度
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel =
                NotificationChannel(notificationChannelId, channelName, importance)
            notificationChannel.description = "Channel description"
            //LED灯
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            //震动
            notificationChannel.vibrationPattern = longArrayOf(0, 1000, 500, 1000)
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }
        val builder = NotificationCompat.Builder(this, notificationChannelId)
        //通知小图标
        builder.setSmallIcon(R.mipmap.ic_launcher)
        //通知标题
        builder.setContentTitle("AndroidServer")
        //通知内容
        builder.setContentText("AndroidServer服务正在运行中")
        //设定通知显示的时间
        builder.setWhen(System.currentTimeMillis())
        //设定启动的内容
        val activityIntent = Intent(this, ForegroundActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            1,
            activityIntent,
            PendingIntent.FLAG_IMMUTABLE
        ) /*FLAG_UPDATE_CURRENT*/
        builder.setContentIntent(pendingIntent)

        //创建通知并返回
        return builder.build()
    }

    override fun onDestroy() {
        //unregisterReceiver(deviceBroadcastReceiver)
        super.onDestroy()
        // 标记服务关闭
        serviceIsLive = false
        // 移除通知
        stopForeground(true)
    }
}
//    原文链接：https://blog.csdn.net/L_201607/article/details/129665945