package com.example.trainingapp.di

import com.example.trainingapp.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            saveBookUseCase = get(),
            getAllBooksUseCase = get()
        )
    }
}