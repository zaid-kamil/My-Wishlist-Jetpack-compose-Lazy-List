package com.digi.mywishlist.data

import kotlinx.coroutines.flow.Flow

interface WishlistRepository {
    fun getWishlist(): Flow<List<Item>>
    fun getWishlistItem(id: Int): Flow<Item>
    suspend fun addItem(item: Item)
    suspend fun removeItem(item: Item)
    suspend fun updateItem(item: Item)
}