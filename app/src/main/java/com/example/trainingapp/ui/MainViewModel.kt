package com.example.trainingapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingapp.domain.model.Book
import com.example.trainingapp.domain.usecase.GetAllBooksUseCase
import com.example.trainingapp.domain.usecase.SaveBookUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val saveBookUseCase: SaveBookUseCase,
    private val getAllBooksUseCase: GetAllBooksUseCase
) : ViewModel() {

    private val _bookList = MutableLiveData<List<Book>>()
    val bookList: LiveData<List<Book>> = _bookList

    fun saveBook(author: String, title: String) = viewModelScope.launch {
        saveBookUseCase.saveBook(createNewBook(author = author, title = title))
    }

    fun getAllBooks() = viewModelScope.launch {
        _bookList.value = getAllBooksUseCase.getAll()
    }

    private fun createNewBook(author: String, title: String) = Book(
        author = author,
        title = title
    )

}