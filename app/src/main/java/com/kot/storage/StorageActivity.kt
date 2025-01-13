package com.kot.storage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kot.storage.ui.theme.AnkotlinTheme
import androidx.compose.foundation.layout.Column


class StorageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnkotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(25.dp)) {
        Button(onClick = {
            // Create and enqueue the worker
        }, modifier = Modifier.padding(10.dp)) {
            Text("internalFile")
        }

        Button(onClick = {
            // Trigger the Periodic Work when the button is clicked
        }, modifier = Modifier.padding(10.dp)) {
            Text("Start Periodic Work")
        }

        Button(onClick = {
            // Trigger the Periodic Work when the button is clicked
        }, modifier = Modifier.padding(10.dp)) {
            Text("Schedule Expedited Work", fontSize = 18.sp)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AnkotlinTheme {
        Greeting2("Android")
    }
}