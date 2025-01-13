package com.kot.storage

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.util.storage.StorageUtil
import com.kot.storage.ui.theme.AnkotlinTheme


class StorageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnkotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(this,
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(context: Context, name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(25.dp)) {
        Button(onClick = {
            StorageUtil.internalFile(context)
        }, modifier = Modifier.padding(10.dp)) {
            Text("internalFile")
        }

        Button(onClick = {
            StorageUtil.externalFilesDir(context)
            // Trigger the Periodic Work when the button is clicked
        }, modifier = Modifier.padding(10.dp)) {
            Text("externalFilesDir")
        }

        Button(onClick = {
            StorageUtil.externalCacheFile(context)
            // Trigger the Periodic Work when the button is clicked
        }, modifier = Modifier.padding(10.dp)) {
            Text("externalCacheFile", fontSize = 18.sp)
        }

    }

}
