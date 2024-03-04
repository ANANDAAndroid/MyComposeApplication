package com.demo.mycomposeapplication

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Inject

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class AppDataBase :RoomDatabase() {
    abstract fun getDao():AppDao
}