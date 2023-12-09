package com.example.b_pride.data.lokal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.b_pride.data.lokal.dao.UserDao
import com.example.b_pride.data.lokal.entity.User

@Database(entities = [User :: class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao

}