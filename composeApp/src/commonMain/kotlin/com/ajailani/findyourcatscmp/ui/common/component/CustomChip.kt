package com.ajailani.findyourcatscmp.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomChip(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    text: String
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(color = MaterialTheme.colors.secondary)
            .padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.let {
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = icon,
                contentDescription = "Chip icon",
                tint = MaterialTheme.colors.onSecondary
            )
        }

        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            fontSize = 12.sp,
            color = MaterialTheme.colors.onSecondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}