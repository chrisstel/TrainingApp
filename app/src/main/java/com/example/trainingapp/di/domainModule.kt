package com.example.trainingapp.di

import com.example.trainingapp.data.database.room.repository.BookRepositoryImpl
import com.example.trainingapp.domain.repository.BookRepository
import com.example.trainingapp.domain.usecase.GetAllBooksUseCase
import com.example.trainingapp.domain.usecase.SaveBookUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<SaveBookUseCase> {
        SaveBookUseCase(
            bookRepository = get()
        )
    }

    factory<GetAllBooksUseCase> {
        GetAllBooksUseCase(
            bookRepository = get()
        )
    }

}