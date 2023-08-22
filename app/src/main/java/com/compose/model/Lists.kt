package com.compose.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 *
 * ClassName:      Lists
 * Description:    Description
 * Author:         zh
 * CreateDate:     8/21/23 23:00
 * UpdateUser:     zh
 * UpdateDate:     8/21/23 23:00
 * UpdateRemark:   Modify the description
 */

@Composable
fun SimpleColumn() {
    Column {
        repeat(100) {
            Text(text = "Item #$it", style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text(text = "Item #$it", style = MaterialTheme.typography.titleMedium)
        }
    }
}

// 能滑动，带缓冲功能，类似于recycleview
@Composable
fun LazyList() {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        items(100) {
            Text(text = "Item #$it", style = MaterialTheme.typography.titleMedium)
        }
    }
}