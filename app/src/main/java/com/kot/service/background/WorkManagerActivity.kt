package com.kot.service.background

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.PeriodicWorkRequestBuilder
import com.kot.service.background.ui.theme.AnkotlinTheme
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit


class WorkManagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnkotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WorkManagerScreen()
                }
            }
        }
    }

    private fun schedulePeriodicWork() {
        val periodicWorkRequest =
            PeriodicWorkRequestBuilder<LogWorker>(15, TimeUnit.MINUTES) // every 15 minutes
                .build()
        // Enqueue the work request
        WorkManager.getInstance(this).enqueue(periodicWorkRequest)
    }

    private fun scheduleExpeditedWork() {
        val workRequest: WorkRequest = OneTimeWorkRequestBuilder<LogWorker>()
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }

    @Composable
    fun Greeting2(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview2() {
        AnkotlinTheme {
//        WorkManagerScreen()
        }
    }

    @Composable
    fun WorkManagerScreen() {
        val workManager = WorkManager.getInstance(this)

        Column(modifier = Modifier.padding(25.dp)) {
            Button(onClick = {
                // Create and enqueue the worker
                val workRequest = OneTimeWorkRequestBuilder<LogWorker>().build()
                workManager.enqueue(workRequest)
            }, modifier = Modifier.padding(10.dp)) {
                Text("OneTimeWork Start Work")
            }

            Button(onClick = {
                // Trigger the Periodic Work when the button is clicked
                schedulePeriodicWork()
            }, modifier = Modifier.padding(10.dp)) {
                Text("Start Periodic Work")
            }

            Button(onClick = {
                // Trigger the Periodic Work when the button is clicked
                scheduleExpeditedWork()
            }, modifier = Modifier.padding(10.dp)) {
                Text("Schedule Expedited Work", fontSize = 18.sp)
            }

        }


    }


}

