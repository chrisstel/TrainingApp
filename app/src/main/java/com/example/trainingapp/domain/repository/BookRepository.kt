package com.example.trainingapp.domain.repository

import com.example.trainingapp.domain.model.Book

interface BookRepository {

    suspend fun save(book: Book)

    suspend fun getAllBooks(): List<Book>
}