package com.example.trainingapp.data.database.room

import android.content.Context
import com.example.trainingapp.data.database.BookStorage
import com.example.trainingapp.data.database.room.db.BookDatabase
import com.example.trainingapp.data.database.room.entity.RoomBook

class RoomBookStorage(context: Context) : BookStorage {
    private val dao = BookDatabase.invoke(context = context).bookDao()

    override suspend fun save(book: RoomBook) {
        dao.insert(book)
    }

    override suspend fun getAll(): List<RoomBook> = dao.getAll()
}