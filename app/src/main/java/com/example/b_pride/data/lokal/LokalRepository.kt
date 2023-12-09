package com.example.b_pride.data.lokal

import com.example.b_pride.data.lokal.entity.User

class LokalRepository(private val appDatabase: AppDatabase) {
    suspend fun insertUser(user: User){
        appDatabase.userDao().insert(user)
    }
    suspend fun getUser(username: String, password: String): User{
        return appDatabase.userDao().getUser(username, password)
    }

    suspend fun getDataByName(username: String): User{
        return appDatabase.userDao().getDataByName(username)
    }
}