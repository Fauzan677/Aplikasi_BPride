package com.example.b_pride.di

import com.example.b_pride.AppRepository
import com.example.b_pride.data.lokal.LokalRepository
import com.example.b_pride.data.remote.RemoteRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single { LokalRepository(get()) }
    single { RemoteRepository(get()) }
    single { AppRepository(get(),get()) }
}