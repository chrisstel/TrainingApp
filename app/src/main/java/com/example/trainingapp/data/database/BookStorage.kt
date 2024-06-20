package com.example.trainingapp.data.database

import com.example.trainingapp.data.database.room.entity.RoomBook

interface BookStorage {

    suspend fun save(book: RoomBook)

    suspend fun getAll(): List<RoomBook>
}