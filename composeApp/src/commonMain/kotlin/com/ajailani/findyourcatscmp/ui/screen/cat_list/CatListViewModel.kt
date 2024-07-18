package com.ajailani.findyourcatscmp.ui.screen.cat_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajailani.findyourcatscmp.data.repository.CatRepository
import com.ajailani.findyourcatscmp.util.ApiResult
import kotlinx.coroutines.launch

class CatListViewModel(
    private val catRepository: CatRepository
) : ViewModel() {

    var uiState by mutableStateOf(CatListUiState())
        private set

    init {
        getCats()
    }

    private fun getCats() {
        uiState = uiState.copy(isLoading = true)

        viewModelScope.launch {
            catRepository.getCats().collect {
                uiState = when (it) {
                    is ApiResult.Success -> {
                        uiState.copy(
                            isLoading = false,
                            cats = it.data ?: emptyList()
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