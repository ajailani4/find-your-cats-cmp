package com.ajailani.findyourcatscmp.ui.common.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Straighten
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ajailani.findyourcatscmp.data.model.Cat
import findyourcatscmp.composeapp.generated.resources.Res
import findyourcatscmp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CatCard(
    modifier: Modifier = Modifier,
    cat: Cat,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        elevation = 4.dp,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = cat.imageLink,
                placeholder = painterResource(Res.drawable.compose_multiplatform),
                contentScale = ContentScale.Crop,
                contentDescription = "Cat image"
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = cat.name,
                    fontSize = 22.sp
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomChip(
                    icon = Icons.Default.Eco,
                    text = cat.origin
                )
                Spacer(modifier = Modifier.height(7.dp))
                CustomChip(
                    icon = Icons.Default.Straighten,
                    text = cat.length
                )
            }
        }
    }
}