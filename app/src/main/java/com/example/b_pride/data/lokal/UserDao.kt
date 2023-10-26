package com.example.b_pride.data.lokal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAll(): List<User>

    @Query("SELECT * FROM user_table WHERE id LIKE :id LIMIT 1")
    suspend fun findByRoll(id: Int): User

    @Query("SELECT * FROM user_table WHERE id=:user_id")
    suspend fun getUser(user_id: Int) : User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()
}