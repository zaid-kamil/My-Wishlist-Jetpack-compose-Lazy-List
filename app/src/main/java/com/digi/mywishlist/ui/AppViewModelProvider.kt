package com.digi.mywishlist.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.digi.mywishlist.WishlistApplication

// step 7: create a viewModelProvider object
object AppViewModelProvider {
    val viewModel = viewModelFactory {
        initializer {
            MyViewModel(wishlistApplication().container.itemsRepository)
        }
    }
}

// step 8: create a wishlistApplication() function (error until step 9)
fun CreationExtras.wishlistApplication(): WishlistApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as WishlistApplication)
