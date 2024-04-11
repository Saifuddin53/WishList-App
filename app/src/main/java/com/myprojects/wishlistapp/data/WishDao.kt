package com.myprojects.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Insert
    abstract suspend fun insertAWish(wish: Wish)

    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateAWish(wish: Wish)

    @Delete
    abstract suspend fun deleteAWish(wish: Wish)

    @Query("Select * from `wish-table` where id = :id")
    abstract fun getAWishById(id: Long): Flow<Wish>
}