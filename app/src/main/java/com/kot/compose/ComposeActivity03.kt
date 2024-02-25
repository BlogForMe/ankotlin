package com.kot.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kot.R
import com.kot.compose.model.Message
import kotlinx.coroutines.launch

/**
 *  05-配置布局
 */
class ComposeActivity03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MessageCard(Message("Android", "Jectpack compse"))
            BottomSheetDemo()
        }
    }

    @Composable
    fun MessageCard(msg: Message) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.id_korean),
                contentDescription = "contact profile ",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(text = msg.author)
                Text(text = msg.body)
            }
            Button(onClick = {
            }) {
                Text(text = "show dialog")
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BottomSheetDemo() {
        // [START android_compose_layout_material_bottom_sheet]
        ModalBottomSheet(onDismissRequest = { /* Executed when the sheet is dismissed */ }) {
            // Sheet content
        }
        // [END android_compose_layout_material_bottom_sheet]

        // [START android_compose_layout_material_bottom_sheet2]
        val sheetState = rememberModalBottomSheetState()
        val scope = rememberCoroutineScope()
        var showBottomSheet by remember { mutableStateOf(false) }
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show bottom sheet") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        showBottomSheet = true
                    }
                )
            }
        ) { contentPadding ->
            // Screen content
            // [START_EXCLUDE silent]
            Box(modifier = Modifier.padding(contentPadding)) { /* ... */ }
            // [END_EXCLUDE]

            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    // Sheet content
                    Button(onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    }) {
                        Text("Hide bottom sheet")
                    }
                }
            }
        }
        // [END android_compose_layout_material_bottom_sheet2]
    }
}

