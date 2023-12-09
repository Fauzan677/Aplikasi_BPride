package com.example.b_pride

import com.example.b_pride.data.lokal.AppDatabase
import com.example.b_pride.data.lokal.LokalRepository
import com.example.b_pride.data.lokal.entity.User
import com.example.b_pride.data.remote.RemoteRepository

class AppRepository(private val lokalRepository: LokalRepository, private val remoteRepository: RemoteRepository) {
    suspend fun insertUser(user: User){
        lokalRepository.insertUser(user)
    }


    suspend fun getUser(username: String, password: String): User{
        return lokalRepository.getUser(username, password)
    }

    suspend fun getDataByName(username: String): User{
        return lokalRepository.getDataByName(username)
    }

    suspend fun getSmartphone() = remoteRepository.getSmartphone()
    suspend fun getLaptop() = remoteRepository.getLaptop()
}