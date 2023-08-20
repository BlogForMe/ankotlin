package com.compose.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kot.R

/**
 *
 * ClassName:      PhotographerCard
 * Description:    Description
 * Author:         zh
 * CreateDate:     8/20/23 21:12
 * UpdateUser:     zh
 * UpdateDate:     8/20/23 21:12
 * UpdateRemark:   Modify the description
 */

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(color = MaterialTheme.colorScheme.background)
            .clickable(onClick = {})
            .padding(16.dp)
    ) {

        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
        ) {
            Image(painter = painterResource(id = R.drawable.meitu11e), contentDescription = null)
        }
        Column(modifier = Modifier
            .padding(start = 8.dp)
            .align(Alignment.CenterVertically)) {

            Text(text = "Slfred sisley", fontWeight = FontWeight.Bold)
            Text(text = "3 minutes ago sisley", style = MaterialTheme.typography.bodyMedium)
        }
    }
}