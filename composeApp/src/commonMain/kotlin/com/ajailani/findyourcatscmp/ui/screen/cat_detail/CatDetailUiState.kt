package com.ajailani.findyourcatscmp.ui.screen.cat_detail

import com.ajailani.findyourcatscmp.data.model.Cat

data class CatDetailUiState(
    val isLoading: Boolean = false,
    val cat: Cat? = null,
    val errorMessage: String? = null
)
