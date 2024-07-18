package com.ajailani.findyourcatscmp.ui.screen.cat_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ajailani.findyourcatscmp.ui.common.component.CatCard

@Composable
fun CatListScreen(
    uiState: CatListUiState,
    onNavigateToCatDetail: (String) -> Unit
) = with(uiState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(text = "Find Your Cats")
                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(20.dp)
        ) {
            items(cats) {
                CatCard(
                    cat = it,
                    onClick = { onNavigateToCatDetail(it.id) }
                )

                if (it != cats.last()) {
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }

        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}