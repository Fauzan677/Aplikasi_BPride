package com.example.b_pride.ui.konten.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.b_pride.AppRepository
import com.example.b_pride.data.remote.response.ProductResponse
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class HomeViewModel(private val appRepository: AppRepository): ViewModel() {
    private val getLaptop = MutableLiveData<Response<ProductResponse>>()
    val observeLaptop: LiveData<Response<ProductResponse>> = getLaptop

    private val getSmartphone = MutableLiveData<Response<ProductResponse>>()
    val observeSmartphone: LiveData<Response<ProductResponse>> = getSmartphone

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

    fun getSmartphone(){
        viewModelScope.launch {
            try {
                val result = appRepository.getSmartphone()
                getSmartphone.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}