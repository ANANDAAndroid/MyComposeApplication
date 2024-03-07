package com.demo.mycomposeapplication.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverter
import com.demo.mycomposeapplication.model.Response
import com.demo.mycomposeapplication.model.Todo

@Dao
interface AppDao {
    @Insert(entity = Todo::class, onConflict =OnConflictStrategy.REPLACE )
    suspend fun insertTodo(todo: Todo):Boolean

    @TypeConverter
    @Query("select * from TODO")
    suspend fun getTodo(todo: Todo):Response
}