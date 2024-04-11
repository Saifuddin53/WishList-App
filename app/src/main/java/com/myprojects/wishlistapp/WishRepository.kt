package com.myprojects.wishlistapp

import com.myprojects.wishlistapp.data.Wish
import com.myprojects.wishlistapp.data.WishDao
import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {
    suspend fun insertAWish(wish: Wish) {
        wishDao.insertAWish(wish)
    }

    fun getAllWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    suspend fun updateAWish(wish: Wish) {
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish) {
        wishDao.deleteAWish(wish)
    }

    fun getAWishById(id: Long): Flow<Wish> = wishDao.getAWishById(id)
}