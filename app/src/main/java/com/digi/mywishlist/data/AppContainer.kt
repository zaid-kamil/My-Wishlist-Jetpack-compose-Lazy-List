package com.digi.mywishlist.data

import android.content.Context

interface AppContainer {
    val itemsRepository: WishlistRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val itemsRepository: WishlistRepository by lazy {
        LocalWishlistRepository(WishlistDatabase.getDatabase(context).itemDao())
    }
}