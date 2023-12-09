package com.example.b_pride.data.remote

class RemoteRepository(private val apiService: ApiService) {
    suspend fun getSmartphone() = apiService.getSmartphone()
    suspend fun getLaptop() = apiService.getLaptop()
}