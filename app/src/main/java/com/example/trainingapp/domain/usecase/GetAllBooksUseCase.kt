package com.example.trainingapp.domain.usecase

import com.example.trainingapp.domain.model.Book
import com.example.trainingapp.domain.repository.BookRepository

class GetAllBooksUseCase(private val bookRepository: BookRepository) {

    suspend fun getAll(): List<Book> = bookRepository.getAllBooks()
}