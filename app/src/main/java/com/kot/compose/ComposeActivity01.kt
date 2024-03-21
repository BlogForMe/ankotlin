package com.kot.compose

import android.graphics.BitmapFactory
import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import com.kot.R
import org.w3c.dom.Text

class ComposeActivity01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MessageCard(name = "My Android")
            EqualBetween()
        }

    }

    @Composable
    fun MessageCard(name: String) {
        Text(text = "Hello $name !")
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(name = "Android")
    }


    @Composable
    fun ArtistAvatar() {
        Box {
            Icon(Icons.Filled.Check, contentDescription = "Check mark")
            Image(
                bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ble_back_home)
                    .asImageBitmap(), contentDescription = "Artist image"
            )
        }
    }

//https://stackoverflow.com/questions/64425848/how-to-set-spacer-between-with-two-elements-in-a-row

    @Composable
    fun EqualBetween() {
//        Row( modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween) {
//            Text("Start")
//            Text("End")
//        }
    }
}