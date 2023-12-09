package com.example.b_pride.data.remote
import com.example.b_pride.data.remote.response.ProductResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("products/category/smartphones")
    suspend fun getSmartphone(): Response<ProductResponse>

    @GET("products/category/laptops")
    suspend fun getLaptop(): Response<ProductResponse>
}