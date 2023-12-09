package com.example.b_pride.data.lokal.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.b_pride.data.lokal.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user ORDER BY id desc LIMIT 1 ")
    suspend fun findByRoll(): User

    @Query("SELECT * FROM user WHERE firstName= :user_name and password= :user_pass")
    suspend fun getUser(user_name: String, user_pass: String) : User

    @Query("SELECT * FROM user WHERE firstName= :userName")
    suspend fun getDataByName(userName: String) : User

    @Query("SELECT * FROM user WHERE id= :userId")
    suspend fun getUser(userId: Int) : User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}