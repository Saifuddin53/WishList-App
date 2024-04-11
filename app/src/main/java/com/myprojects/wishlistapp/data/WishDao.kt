package com.myprojects.wishlistapp.data

import androidx.room.Insert

abstract class WishDao {
    @Insert
    abstract fun insertWish(wish: Wish)
}