package com.digi.mywishlist

import android.app.Application
import com.digi.mywishlist.data.AppContainer
import com.digi.mywishlist.data.AppDataContainer

class WishlistApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}