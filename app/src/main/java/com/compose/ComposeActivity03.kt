package com.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.compose.model.Message

class ComposeActivity03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jectpack compse"))
        }

    }

    @Composable
    fun MessageCard(msg: Message) {
        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }
    }


}