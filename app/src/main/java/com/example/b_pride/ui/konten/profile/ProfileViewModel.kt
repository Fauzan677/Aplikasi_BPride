package com.example.b_pride.ui.konten.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.b_pride.AppRepository
import com.example.b_pride.data.lokal.entity.User
import kotlinx.coroutines.launch

class ProfileViewModel(private val appRepository: AppRepository): ViewModel() {
    private val getProfile = MutableLiveData<User>()
    fun observeprofile(): LiveData<User> = getProfile

    fun getDataProfile(username: String){
        viewModelScope.launch {
            when(val result = appRepository.getDataByName(username)){
                is User -> {
                    getProfile.postValue(result)
                }
            }
        }
    }
}