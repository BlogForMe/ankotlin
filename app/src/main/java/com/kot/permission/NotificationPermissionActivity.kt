package com.kot.permission

import android.Manifest
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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
    private val notificationManager: NotificationManagerCompat by lazy {
        NotificationManagerCompat.from(this)
    }
    private val CHANNEL_ID = "dummy_channel"
    private val TAG = "PermissionActivity"
    val permission = Manifest.permission.POST_NOTIFICATIONS
    val channelName = "General Money Packet"

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
            }
        }

        // Sets up notification channel.

        // Sets up button.
        binding.buttonShowNotification.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    permission,
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                logData()
                createNotificationChannel()
                showDummyNotification()
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(
                    permission
                )
            ) {
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


        }

        binding.buttonSendNotification.setOnClickListener {
            showDummyNotification()
        }

        binding.buttonOpenSetting.setOnClickListener {
//            openNotificationSettingsForApp(CHANNEL_ID)
            goNotificationSettings(this, CHANNEL_ID)
        }

        // Refresh UI.
        refreshUI()
    }

    private fun logData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // did not open channel
            if (NotificationManager.IMPORTANCE_NONE == NotificationManagerCompat.from(this)
                    .getNotificationChannel(CHANNEL_ID)?.importance
            ) {

            }
            Log.i(
                TAG,
                "channelName importance:  ${
                    notificationManager.getNotificationChannel(
                        CHANNEL_ID
                    )?.importance
                }"
            )

            val channel = notificationManager.getNotificationChannel(
                CHANNEL_ID
            )
            Log.i(TAG, "logData: $channel")

//            Log.i(
//                TAG,
//                "channelName importance:  ${
//                    notificationManager.getNotificationChannel(
//                        CHANNEL_ID
//                    )
//                }"
//            )
        }
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

            myNotificationChannel.setSound(generateSoundUri(this, "notification"), null)
            notificationManager.createNotificationChannel(myNotificationChannel)
        }
    }


    /**
     * https://stackoverflow.com/questions/32366649/any-way-to-link-to-the-android-notification-settings-for-my-app
     */
    fun goNotificationSettings(context: Context, channelId: String? = null) {
        try {
            val notificationSettingsIntent = when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O /*8.0*/ -> Intent().apply {
                    action =
                        if (channelId.isNullOrEmpty() || notificationManager.areNotificationsEnabled()
                                .not()
                        ) {
                            Settings.ACTION_APP_NOTIFICATION_SETTINGS
                        } else {
                            Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS
                        }
                    if (notificationManager.areNotificationsEnabled()) {
                        channelId?.let { putExtra(Settings.EXTRA_CHANNEL_ID, it) }
                    }
                    putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P /*28*/) {
//                        flags += Intent.FLAG_ACTIVITY_NEW_TASK
//                    }
                }

                else/*21*/ -> Intent().apply {
                    action = "android.settings.APP_NOTIFICATION_SETTINGS"
                    putExtra("app_package", context.packageName)
                    putExtra("app_uid", context.applicationInfo.uid)
                }
            }
            resultLauncher.launch(notificationSettingsIntent)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        Log.i(TAG, "onActivityResult: ")
//    }


    /**
     * Shows a notification to user.
     *
     * The notification won't appear if the user doesn't grant notification permission first.
     */
    private fun showDummyNotification() {
        val generateSoundUri = generateSoundUri(this, "notification")
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSound(generateSoundUri)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Congratulations! 🎉🎉🎉")
            .setContentText("You have post a notification to Android 13!!!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    this@NotificationPermissionActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(1, builder.build())
        }
    }


    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            refreshUI()
//            doSomeOperations()
            Log.i(TAG, ": registerForActivityResult")
            logData()
//            }
        }

    private fun generateSoundUri(context: Context, sound: String): Uri? {
        val soundSourceId = getSoundSourceId(context, sound)
        return Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.applicationContext
                .packageName + "/" + soundSourceId
        )
    }

    private fun getSoundSourceId(context: Context, source: String): Int {
        return context.resources.getIdentifier(source, "raw", context.packageName)
    }
}