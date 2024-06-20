package com.example.trainingapp.data.database.room.repository

import com.example.trainingapp.data.database.BookStorage
import com.example.trainingapp.data.database.room.entity.RoomBook
import com.example.trainingapp.domain.model.Book
import com.example.trainingapp.domain.repository.BookRepository

class BookRepositoryImpl(private val roomBookStorage: BookStorage) : BookRepository {

    override suspend fun save(book: Book) {
        val newBook = RoomBook(author = book.author, title = book.title)
        roomBookStorage.save(newBook)
    }

    override suspend fun getAllBooks(): List<Book> = roomBookStorage.getAll().map { currBook ->
        Book(
            id = currBook.id,
            author = currBook.author,
            title = currBook.title
        )
    }
}