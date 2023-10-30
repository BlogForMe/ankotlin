package com.kot.permission

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityJetpackPermissionBinding


class JetpackPermissionActivity : AppCompatActivity() {

    val binding by viewBinding(ActivityJetpackPermissionBinding::inflate)

    private val notificationManager: NotificationManager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btRequest.setOnClickListener {
            requestPermission()
        }

        binding.btSetNotification.setOnClickListener {
            showDummyNotification()
        }

        createNotificationChannel()
    }

    /**
     * Creates Notification Channel (required for API level >= 26) before sending any notification.
     */
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            NotificationPermissionActivity.CHANNEL_ID,
            "Important Notification Channel",
            NotificationManager.IMPORTANCE_HIGH,
        ).apply {
            description = "This notification contains important announcement, etc."
        }
        notificationManager.createNotificationChannel(channel)
    }


//    private fun createNotificationChannel() {
//        val channel_name = "channel_name"
//        val channel_description = "channel_description"
//        val CHANNEL_ID = "CHANNEL_ID"
//        // Create the NotificationChannel, but only on API 26+ because
//        // the NotificationChannel class is not in the Support Library.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val name: CharSequence = channel_name
//            val description = channel_description
//            val importance = NotificationManager.IMPORTANCE_DEFAULT
//            val channel = NotificationChannel(CHANNEL_ID, name, importance)
//            channel.description = description
//            // Register the channel with the system; you can't change the importance
//            // or other notification behaviors after this.
//            val notificationManager = getSystemService(
//                NotificationManager::class.java
//            )
//            notificationManager.createNotificationChannel(channel)
//        }
//    }


    /**
     * Shows a notification to user.
     *
     * The notification won't appear if the user doesn't grant notification permission first.
     */
    @RequiresApi(Build.VERSION_CODES.O)
    private fun showDummyNotification() {
        if (ActivityCompat.checkSelfPermission(
                this,
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

        val builder = NotificationCompat.Builder(this, NotificationPermissionActivity.CHANNEL_ID)
            .setSmallIcon(com.kot.R.drawable.ic_launcher_foreground)
            .setContentTitle("Congratulations! 🎉🎉🎉")
            .setContentText("You have post a notification to Android 13!!!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        NotificationManagerCompat.from(this).notify(2, builder.build())
    }


    val permission = Manifest.permission.POST_NOTIFICATIONS

    @RequiresApi(Build.VERSION_CODES.M)
    fun requestPermission() {
        if (ContextCompat.checkSelfPermission(
                this, permission
            ) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            // You can use the API that requires the permission.
//            performAction(...);
            Toast.makeText(this, "had NOTIFICATIONS permission", Toast.LENGTH_SHORT).show()
        } else if (shouldShowRequestPermissionRationale(permission)) {
            // In an educational UI, explain to the user why your app requires this
            // permission for a specific feature to behave as expected, and what
            // features are disabled if it's declined. In this UI, include a
            // "cancel" or "no thanks" button that lets the user continue
            // using your app without granting the permission.
//            showInContextUI(...);
            Toast.makeText(this, "need permisson", Toast.LENGTH_SHORT).show()
        } else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.
            Toast.makeText(this, "to ask permisson", Toast.LENGTH_SHORT).show()
            requestPermissionLauncher.launch(
                permission
            );
        }
    }

    // Register the permissions callback, which handles the user's response to the
    // system permissions dialog. Save the return value, an instance of
    // ActivityResultLauncher, as an instance variable.
    private val requestPermissionLauncher = registerForActivityResult(
        RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission is granted. Continue the action or workflow in your
            // app.
            Toast.makeText(this, "congraduate grant permisson", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "you deny permisson", Toast.LENGTH_SHORT).show()
            // Explain to the user that the feature is unavailable because the
            // feature requires a permission that the user has denied. At the
            // same time, respect the user's decision. Don't link to system
            // settings in an effort to convince the user to change their
            // decision.
        }
    }

}


