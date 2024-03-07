package com.demo.mycomposeapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TODO")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int = 0,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("desc") val desc: String,


)

data class Response(val todos:List<Todo>)
