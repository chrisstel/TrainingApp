package com.example.trainingapp.data.database.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.trainingapp.data.database.room.dao.BookDao
import com.example.trainingapp.data.database.room.entity.RoomBook

@Database(entities = [RoomBook::class], version = 1)
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {

        @Volatile
        private var instance: BookDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            BookDatabase::class.java,
            "books.db"
        ).build()
    }
}