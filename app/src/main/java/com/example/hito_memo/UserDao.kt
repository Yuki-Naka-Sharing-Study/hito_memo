package com.example.hito_memo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReview(vararg reviews: UserEntity)

    @Update
    fun updateReviews(vararg reviews: UserEntity)

    @Delete
    fun delete(review: UserEntity)

    @Query("SELECT * FROM user_data_table")
    fun getAll(): List<UserEntity>
}