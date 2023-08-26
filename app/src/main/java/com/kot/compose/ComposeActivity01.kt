package com.kot.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ComposeActivity01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(name = "My Android")
        }

    }

    @Composable
    fun MessageCard(name: String) {
        Text(text = "Hello $name !")
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(name = "googd at Android")
    }


}