package com.example.b_pride.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.b_pride.AppRepository
import com.example.b_pride.data.lokal.entity.User
import kotlinx.coroutines.launch

class LoginViewModel(private val appRepository: AppRepository): ViewModel() {
    private val isLogin = MutableLiveData<User>()
    fun observeIsLogin(): LiveData<User> = isLogin

    fun getDataLogin(username: String, password: String){
        viewModelScope.launch {
            when(val result = appRepository.getUser(username, password)){
                is User -> {
                    isLogin.postValue(result)
                }
            }
        }
    }

}