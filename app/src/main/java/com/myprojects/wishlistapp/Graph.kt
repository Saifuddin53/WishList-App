package com.myprojects.wishlistapp

import android.content.Context
import androidx.room.Room
import com.myprojects.wishlistapp.data.WishDatabase

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy{
        WishRepository(database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}