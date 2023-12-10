package com.digi.mywishlist.data

enum class Priority {
    High,
    Medium,
    Low
}

data class Item(
    val title: String,
    val website: String,
    val img: String = "",
    val priority: Priority = Priority.Low
)
