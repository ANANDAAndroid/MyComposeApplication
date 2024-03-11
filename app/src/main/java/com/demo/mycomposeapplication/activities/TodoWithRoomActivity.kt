package com.demo.mycomposeapplication.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.demo.mycomposeapplication.Viewmodel
import com.demo.mycomposeapplication.api.Status
import com.demo.mycomposeapplication.database.AppDataBase
import com.demo.mycomposeapplication.model.Response
import com.demo.mycomposeapplication.model.TodoModel
import com.demo.mycomposeapplication.screens.Todo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class TodoWithRoomActivity : ComponentActivity() {
    private val viewmodel by viewModels<Viewmodel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel.getTodoData()
        setContent {
            val todoList = remember { mutableStateOf(emptyList<TodoModel>()) }
            Todo(todoModelList = todoList.value.asReversed()) { title, desc ->
                viewmodel.insertData(TodoModel(id = 0, title = title, desc = desc))
            }
            when (val result = viewmodel.responseInsertData.collectAsState().value) {
                is Status.Loading -> {

                }

                is Status.Success -> {
                    if (result.data > 0) {
                            viewmodel.getTodoData()
                    }
                }

                is Status.Failure -> {
                    Toast.makeText(this, "insertion failed", Toast.LENGTH_SHORT).show()
                }
            }

            when (val result = viewmodel.responseGetData.collectAsState().value) {
                is Status.Loading -> {
                }

                is Status.Success -> {
                    if (result.data.isNotEmpty()) {
                      todoList.value=  result.data
                    }
                }

                is Status.Failure -> {
                    Toast.makeText(this, "fetched failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}

