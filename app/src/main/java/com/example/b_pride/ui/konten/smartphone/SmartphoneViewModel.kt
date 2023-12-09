package com.example.b_pride.ui.konten.smartphone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.b_pride.AppRepository
import com.example.b_pride.data.remote.response.ProductResponse
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class SmartphoneViewModel(private val appRepository: AppRepository): ViewModel() {
    private val getSmartphone = MutableLiveData<Response<ProductResponse>>()
    val observeSmartphone: LiveData<Response<ProductResponse>> = getSmartphone

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