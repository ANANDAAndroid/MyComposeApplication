package com.demo.mycomposeapplication

import androidx.room.RoomDatabase
import com.demo.mycomposeapplication.api.ApiService
import com.demo.mycomposeapplication.api.DataSource
import com.demo.mycomposeapplication.database.AppDataBase
import com.demo.mycomposeapplication.model.Todo
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService ,private val appDataBase: AppDataBase): DataSource() {

    suspend fun getData()= getData {
        apiService.getData()
    }

    suspend fun insertToDo(todo: Todo)=getData {
        appDataBase.getDao().insertTodo(todo)
    }
}