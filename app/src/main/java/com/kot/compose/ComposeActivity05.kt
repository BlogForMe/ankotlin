package com.kot.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kot.R
import com.kot.compose.model.Message
import com.kot.compose.model.SampleData
import com.kot.compose.util.BasicsCodelabTheme

/**
 *  08 动画
 */
class ComposeActivity05 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
//                Conversation(SampleData.conversationSample)
                GestureSample()
            }
        }
    }

    @Composable
    fun MessageCard(msg: Message) {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            Image(
                painter = painterResource(id = R.drawable.id_korean),
                contentDescription = "contact profile ",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor: Color by animateColorAsState( // 设置动画
                if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
            )
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    modifier = Modifier.padding(all = 4.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Surface(
                    color = surfaceColor,
                    shadowElevation = 1.dp,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = msg.body,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            stickyHeader {
                Column(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                ) {
                    Text(
                        text = "header",
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }
            items(messages) { message ->
                MessageCard(msg = message)
            }
        }
    }

    @Composable
    fun PreviewMessage() {
        Conversation(SampleData.conversationSample)
    }


    @Preview
    @Composable
    fun GestureSample() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        )
        {
            NestedScroollSample()
        }
    }


    @Composable
    fun NestedScroollSample() {
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .verticalScroll(rememberScrollState())
                .padding(32.dp)
        ) {
            Column {
                repeat(6) {
                    Box(
                        modifier = Modifier
                            .height(140.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = "Scroll here",
                            modifier = Modifier
                                .border(12.dp, Color.DarkGray)
                                .background(Color.Yellow)
                                .padding(24.dp)
                                .height(200.dp)
                        )
                    }
                }
            }
        }


    }

}

