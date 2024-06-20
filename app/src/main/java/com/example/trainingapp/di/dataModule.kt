package com.example.trainingapp.di

import com.example.trainingapp.data.database.BookStorage
import com.example.trainingapp.data.database.room.RoomBookStorage
import com.example.trainingapp.data.database.room.repository.BookRepositoryImpl
import com.example.trainingapp.domain.repository.BookRepository
import org.koin.dsl.module

val dataModule = module {

    single<BookStorage> {
        RoomBookStorage(
            context = get()
        )
    }

    single<BookRepository> {
        BookRepositoryImpl(
            roomBookStorage = get()
        )
    }

}