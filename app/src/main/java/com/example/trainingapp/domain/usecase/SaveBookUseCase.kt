package com.example.trainingapp.domain.usecase

import com.example.trainingapp.domain.model.Book
import com.example.trainingapp.domain.repository.BookRepository

class SaveBookUseCase(private val bookRepository: BookRepository) {

    suspend fun saveBook(book: Book) {
        bookRepository.save(book)
    }
}