package com.example.b_pride.ui.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.b_pride.AppRepository
import com.example.b_pride.data.lokal.AppDatabase
import com.example.b_pride.data.lokal.entity.User
import kotlinx.coroutines.launch

class RegisterViewModel(private val appRepository: AppRepository): ViewModel() {
    private val isRegister = MutableLiveData<Boolean>()

    fun observeIsRegister(): LiveData<Boolean> = isRegister

    fun insertUser(user: User){
        viewModelScope.launch {
            try {
                appRepository.insertUser(user)
                isRegister.postValue(true)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}