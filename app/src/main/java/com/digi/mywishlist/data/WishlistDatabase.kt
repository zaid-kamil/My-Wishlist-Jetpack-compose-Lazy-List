package com.digi.mywishlist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class WishlistDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: WishlistDatabase? = null
        fun getDatabase(context: Context): WishlistDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    WishlistDatabase::class.java, "wishlist_database"
                )
                    .build()
                    .also { Instance = it }
            }
        }
    }
}