package com.demo.mycomposeapplication.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.demo.mycomposeapplication.Viewmodel
import com.demo.mycomposeapplication.api.Status
import com.demo.mycomposeapplication.model.Response
import com.demo.mycomposeapplication.model.TodoModel
import com.demo.mycomposeapplication.screens.Todo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoWithRoomActivity : ComponentActivity() {
    private val viewmodel by viewModels<Viewmodel> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {



            val todoList=Response(listOf())
            Todo(todoList.todoModels){ title, desc ->
                viewmodel.insertData(TodoModel(0,title, desc))
            }

            when(val result=viewmodel.responseInsertData.collectAsState().value){
                is Status.Loading ->{

                }
                is Status.Success ->{
                    if (result.data>0){
                        Toast.makeText(this, "inserted successfully", Toast.LENGTH_SHORT).show()
                    }
                }
                is Status.Failure ->{

                }
            }
        }
    }
}

