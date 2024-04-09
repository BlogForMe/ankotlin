package com.kot.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 *
 * ClassName:      BottomSheetDialog
 * Description:    Description
 * Author:         zh
 * CreateDate:     07/04/2024
 * UpdateUser:     zh
 * UpdateDate:     07/04/2024
 * UpdateRemark:   Modify the description
 */


class MyBottomSheetDialogFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Header", color = Color.Black)
                    LazyColumn(
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        items(100) {
                            Text("Item $it", Modifier.fillMaxWidth(), Color.Black)
                        }
                    }
                }
            }
        }
    }
}