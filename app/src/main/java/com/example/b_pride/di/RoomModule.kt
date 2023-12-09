package com.example.b_pride.di

import androidx.room.Room
import com.example.b_pride.data.lokal.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val RoomModule = module {
    single{
        Room.databaseBuilder(androidContext(), AppDatabase::class.java,"db")
            .fallbackToDestructiveMigration()
            .build()
    }
}