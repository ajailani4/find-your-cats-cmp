package com.ajailani.findyourcatscmp.ui.screen.cat_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajailani.findyourcatscmp.util.ApiResult
import com.ajailani.findyourcatscmp.data.repository.CatRepository
import kotlinx.coroutines.launch

class CatDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val catRepository: CatRepository
) : ViewModel() {
    private val id = savedStateHandle.get<String>("id")

    var uiState by mutableStateOf(CatDetailUiState())
        private set

    init {
        getCatDetail()
    }

    private fun getCatDetail() {
        uiState = uiState.copy(isLoading = true)

        viewModelScope.launch {
            catRepository.getCatDetail(id ?: "").collect {
                uiState = when (it) {
                    is ApiResult.Success -> {
                        uiState.copy(
                            isLoading = false,
                            cat = it.data
                        )
                    }

                    is ApiResult.Error -> {
                        uiState.copy(
                            isLoading = false,
                            errorMessage = it.message
                        )
                    }
                }
            }
        }
    }
}