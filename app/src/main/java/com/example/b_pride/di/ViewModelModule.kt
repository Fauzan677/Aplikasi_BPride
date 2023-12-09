package com.example.b_pride.di

import com.example.b_pride.ui.konten.home.HomeViewModel
import com.example.b_pride.ui.konten.laptop.LaptopViewModel
import com.example.b_pride.ui.konten.profile.ProfileViewModel
import com.example.b_pride.ui.konten.smartphone.SmartphoneViewModel
import com.example.b_pride.ui.login.LoginViewModel
import com.example.b_pride.ui.register.RegisterViewModel
import org.koin.dsl.module

val viewModelModule = module{
    single{ LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
    single { SmartphoneViewModel(get()) }
    single { LaptopViewModel(get()) }
    single { HomeViewModel(get()) }
    single { ProfileViewModel(get()) }
}