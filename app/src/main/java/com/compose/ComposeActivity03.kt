package com.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.model.Message
import com.compose.theme.BasicsCodelabTheme

class ComposeActivity03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MessageCard(Message("Android", "Jectpack compse"))
            Greeting(name = "Android")
//            BasicsCodelabTheme {
//                MyApp()
//            }
//            MyApp()
        }
        val dpConvert = 24.dp
        Log.i("ComposeActivity03", "onCreate: $dpConvert")
    }

    @Composable
    fun MyApp(
        modifier: Modifier = Modifier,
        names: List<String> = listOf("World", "Compose"),
    ) {
        Column(modifier = modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }

//    @Composable
//    private fun Greeting(name: String) {
//        Surface(
//            color = MaterialTheme.colorScheme.primary,
//            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//        ) {
//            Column(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
//                Text(text = "Hello, ")
//                Text(text = name)
//            }
//        }
//    }


    // Don't copy over
    @Composable
    private fun Greeting(name: String) {
//        var expanded = false // Don't do this!
        val expanded = remember { mutableStateOf(false) }
        val extraPadding = if (expanded.value) 48.dp else 0.dp
        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(extraPadding)) {
                    Text(text = "good, ")
                    Text(text = name)
                }
//                ElevatedButton(
//                    onClick = { expanded = !expanded }
//                ) {
//                    Text(if (expanded) "Show less" else "Show more")
//                }

                ElevatedButton(
                    onClick = { expanded.value = !expanded.value },
                ) {
                    Text(if (expanded.value) "Show less" else "Show more")
                }
            }
        }
    }


//    @Composable
//    private fun MyApp(modifier: Modifier = Modifier) {
//        Surface(
//            modifier = modifier,
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Greeting(name = "Android")
//        }
//    }


//    @Composable
//    private fun Greeting(name: String) {
//        Surface(color = MaterialTheme.colorScheme.primary) {
//            Text(text = "good $name!", modifier = Modifier.padding(24.dp))
//        }
//    }


//    @Preview
//    @Composable
//    fun PreviewMessageCard() {
//        Greeting(name = "at Android")
//    }

    @Composable
    fun MessageCard(msg: Message) {
        Surface(color = MaterialTheme.colorScheme.primary) {
            Column {
                Text(text = msg.author)
                Text(text = msg.body)
            }
        }
    }


//    @Preview(showBackground = true, widthDp = 320)
//    @Composable
//    fun DefaultPreview() {
//        BasicsCodelabTheme {
//            MyApp()
//        }
//    }
}