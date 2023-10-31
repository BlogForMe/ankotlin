package com.kot.permission

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.android.util.viewbind.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.kot.R
import com.kot.databinding.ActivityJetpackNotificationBinding


class NotificationPermissionActivity : AppCompatActivity() {
    private lateinit var myNotificationChannel: NotificationChannel
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>
    private val notificationManager: NotificationManager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
    private val CHANNEL_ID = "dummy_channel"
    private val TAG = "PermissionActivity"
    val permission = Manifest.permission.POST_NOTIFICATIONS
    val channelName = "Notification Channel"

    private val binding by viewBinding(ActivityJetpackNotificationBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack_notification)

        // Sets up permissions request launcher.
        requestPermissionLauncher = registerForActivityResult(RequestPermission()) {
            refreshUI()
            if (it) {
                showDummyNotification()
            } else {
                Snackbar.make(
                    findViewById<View>(android.R.id.content).rootView,
                    "Please grant Notification permission from App Settings",
                    Snackbar.LENGTH_LONG
                ).show()

                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                val uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
                startActivity(intent)
            }
        }

        // Sets up notification channel.
        createNotificationChannel()

        // Sets up button.
        binding.buttonShowNotification.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    permission,
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                showDummyNotification()
            } else if (shouldShowRequestPermissionRationale(permission)) {
                // In an educational UI, explain to the user why your app requires this
                // permission for a specific feature to behave as expected, and what
                // features are disabled if it's declined. In this UI, include a
                // "cancel" or "no thanks" button that lets the user continue
                // using your app without granting the permission.
//            showInContextUI(...);
                Toast.makeText(this, "need permisson", Toast.LENGTH_SHORT).show()
            } else {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }

            Log.i(TAG, "refreshUI: Notifications ${notificationManager.areNotificationsEnabled()}")


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                if (NotificationManager.IMPORTANCE_NONE == notificationManager.getNotificationChannel(
                        CHANNEL_ID
                    ).importance
                ) {

                }
                Log.i(
                    TAG,
                    "channelName importance:  ${
                        notificationManager.getNotificationChannel(
                            CHANNEL_ID
                        ).importance
                    }"
                )
            }
        }

        binding.buttonSendNotification.setOnClickListener {
            showDummyNotification()
        }

        binding.buttonOpenSetting.setOnClickListener {
            openNotificationSettingsForApp(CHANNEL_ID)
        }

        // Refresh UI.
        refreshUI()
    }

    /**
     * Refresh UI elements.
     */
    private fun refreshUI() {
        findViewById<TextView>(R.id.text_notification_enabled).text =
            if (notificationManager.areNotificationsEnabled()) "TRUE" else "FALSE"

    }

    /**
     * Creates Notification Channel (required for API level >= 26) before sending any notification.
     */
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            myNotificationChannel = NotificationChannel(
                CHANNEL_ID,
                channelName,
                NotificationManager.IMPORTANCE_HIGH,
            ).apply {
                description = "This notification contains important announcement, etc."
            }
            notificationManager.createNotificationChannel(myNotificationChannel)
        }

    }


    private fun openNotificationSettingsForApp(channelId: String?) {
        // Links to this app's notification settings.
        val intent = Intent()
        intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && channelId != null) {
            intent.action = Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS
            intent.putExtra(Settings.EXTRA_CHANNEL_ID, channelId)
            intent.putExtra("android.provider.extra.APP_PACKAGE", packageName)
        }
        intent.putExtra("app_package", packageName)
        intent.putExtra("app_uid", applicationInfo.uid)
        startActivity(intent)
    }

    /**
     * Shows a notification to user.
     *
     * The notification won't appear if the user doesn't grant notification permission first.
     */
    private fun showDummyNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Congratulations! 🎉🎉🎉")
            .setContentText("You have post a notification to Android 13!!!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        with(NotificationManagerCompat.from(this)) {
            notify(1, builder.build())
        }
    }

}