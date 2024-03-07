package com.demo.mycomposeapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.mycomposeapplication.model.TodoModel

@Dao
interface AppDao {
    @Insert(entity = TodoModel::class, onConflict =OnConflictStrategy.REPLACE )
    suspend fun insertTodo(todoModel: TodoModel):Long


    @Query("select * from TODO")
    suspend fun getTodo():List<TodoModel>
}