package com.demo.mycomposeapplication.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.mycomposeapplication.model.Response
import com.demo.mycomposeapplication.model.Todo
import com.demo.mycomposeapplication.screens.Todo

class TodoWithRoomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val todoList=Response(listOf())
            Todo(todoList.todos)
        }
    }
}

