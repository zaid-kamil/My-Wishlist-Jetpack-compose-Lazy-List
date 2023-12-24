package com.digi.mywishlist.ui

import androidx.lifecycle.ViewModel
import com.digi.mywishlist.data.Item
import com.digi.mywishlist.data.WishlistRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel(private val itemsRepository: WishlistRepository) : ViewModel() {
    private var _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun onItemSelected(item: Item) {
        //_uiState.update { UiState(selectedItem = item) } or
        _uiState.value = UiState(selectedItem = item)
    }
}