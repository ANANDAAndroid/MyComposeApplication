package com.demo.mycomposeapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.mycomposeapplication.model.TodoModel
import com.demo.mycomposeapplication.ui.theme.MyComposeApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Todo(todoModelList: List<TodoModel>, value: (title: String, desc: String) -> Unit) {
    MyComposeApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Todo App", fontWeight = FontWeight.Bold) },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Yellow)
                    )

                },
                floatingActionButton = {
                    val showDialog = remember { mutableStateOf(false) }
                    FloatingActionButton(
                        onClick = {
                            showDialog.value = true
                        },
                        containerColor = Color.Yellow,
                        shape = CircleShape
                    ) {
                        TodoDialog(showDialog = showDialog) { title, desc ->
                            value(title, desc)
                        }
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                    }


                },
                floatingActionButtonPosition = FabPosition.End
            ) {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                ) {
                    RecycleView(list = todoModelList)
                }
            }
        }
    }
}


@Composable
private fun RecycleView(list: List<TodoModel>) {
    LazyColumn {
        items(list) {
            ItemTodo(it.title, it.desc)
        }
    }
}

@Composable
internal fun ItemTodo(title: String, desc: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(
                text = desc, fontSize = 14.sp,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }


}


@Composable
private fun TodoDialog(showDialog: MutableState<Boolean>,value:(title:String,desc:String) -> Unit) {
    val title = remember { mutableStateOf("") }
    val desc = remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current
    if (showDialog.value) {
        AlertDialog(onDismissRequest = { }, confirmButton = {
            OutlinedButton(onClick = {
                value(title.value,desc.value)
                showDialog.value = false
            }, shape = RoundedCornerShape(5.dp)) {
                Text(text = "Save")
            }
        },
            shape = RoundedCornerShape(10.dp),
            title = {
                Text(text = "Add your todo", fontSize = 11.sp)
            },

            text = {
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    OutlinedTextField(value = title.value,
                        onValueChange = { title.value = it },
                        placeholder = {
                            Text(text = "Add title")
                        },
                        label = {
                            Text(text = "Title")
                        }
                    )
                    OutlinedTextField(value = desc.value,
                        onValueChange = { desc.value = it },
                        placeholder = {
                            Text(text = "Add description")
                        },
                        label = {
                            Text(text = "Description")
                        })
                }

            },
            containerColor = Color.White
        )
    }

}