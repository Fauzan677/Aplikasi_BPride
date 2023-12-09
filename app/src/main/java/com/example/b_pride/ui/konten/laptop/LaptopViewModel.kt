package com.example.b_pride.ui.konten.laptop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.b_pride.AppRepository
import com.example.b_pride.data.remote.response.ProductResponse
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class LaptopViewModel(private val appRepository: AppRepository): ViewModel() {
    private val getLaptop = MutableLiveData<Response<ProductResponse>>()
    val observeLaptop: LiveData<Response<ProductResponse>> = getLaptop

    fun getLaptop(){
        viewModelScope.launch {
            try {
                val result = appRepository.getLaptop()
                getLaptop.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}