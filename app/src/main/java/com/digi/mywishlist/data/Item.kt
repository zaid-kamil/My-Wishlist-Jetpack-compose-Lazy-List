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
    val imgLocal:Int = 0,
    val priority: Priority = Priority.Low,
    val isImgLocal: Boolean = false,
)
