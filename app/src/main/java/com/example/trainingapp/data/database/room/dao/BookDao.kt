package com.example.trainingapp.data.database.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.trainingapp.data.database.room.entity.RoomBook

@Dao
interface BookDao {

    @Query("SELECT * FROM roombook")
    suspend fun getAll(): List<RoomBook>

    @Insert
    suspend fun insert(vararg books: RoomBook)

    @Delete
    suspend fun delete(book: RoomBook)
}