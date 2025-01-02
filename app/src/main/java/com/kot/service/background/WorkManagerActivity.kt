package com.kot.service.background

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.OneTimeWorkRequestBuilder
import com.kot.service.background.ui.theme.AnkotlinTheme
import androidx.work.WorkManager


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
        val workManager = WorkManager.getInstance()

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                // Create and enqueue the worker
                val workRequest = OneTimeWorkRequestBuilder<LogWorker>().build()
                workManager.enqueue(workRequest)
            }) {
                Text("Start Work")
            }
        }
    }
}