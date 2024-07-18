package com.ajailani.findyourcatscmp.ui.screen.cat_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ajailani.findyourcatscmp.ui.common.component.CatAttribute
import com.ajailani.findyourcatscmp.util.CatAttributeType
import findyourcatscmp.composeapp.generated.resources.Res
import findyourcatscmp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun CatDetailScreen(
    uiState: CatDetailUiState,
    onNavigateUp: () -> Unit
) = with(uiState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detail")
                },
                backgroundColor = Color.White,
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back icon"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        when {
            isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            cat != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                        .padding(20.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .size(250.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            model = cat.imageLink,
                            placeholder = painterResource(Res.drawable.compose_multiplatform),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Cat image"
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = cat.name,
                            fontSize = 28.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        CatAttribute(key = "Origin", value = CatAttributeType.Text(cat.origin))
                        CatAttribute(key = "Length", value = CatAttributeType.Text(cat.length))
                        CatAttribute(key = "Family Friendly", value = CatAttributeType.Rating(cat.familyFriendlyRating))
                        CatAttribute(key = "General Health", value = CatAttributeType.Rating(cat.generalHealthRating))
                        CatAttribute(key = "Grooming", value = CatAttributeType.Rating(cat.groomingRating))
                    }
                }
            }
        }
    }
}