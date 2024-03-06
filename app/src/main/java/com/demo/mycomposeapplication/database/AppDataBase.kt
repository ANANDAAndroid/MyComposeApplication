package com.demo.mycomposeapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.mycomposeapplication.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class AppDataBase :RoomDatabase() {
    abstract fun getDao(): AppDao
}