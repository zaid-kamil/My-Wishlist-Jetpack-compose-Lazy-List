package com.digi.mywishlist

import android.app.Application
import com.digi.mywishlist.data.AppContainer
import com.digi.mywishlist.data.AppDataContainer

// step 9 : create application class and add it to manifest
class WishlistApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}