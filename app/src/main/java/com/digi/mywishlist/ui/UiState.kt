package com.digi.mywishlist.ui

import com.digi.mywishlist.data.Item
import com.digi.mywishlist.data.Priority

data class UiState(
    val selectedItem: Item? = null,
    val items: List<Item> = emptyList(),
    val title: String = "",
    val website: String = "",
    val img: String = "",
    val priority: Priority = Priority.Low,
)

