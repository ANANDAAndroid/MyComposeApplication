package com.demo.mycomposeapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TODO")
data class Todo(
    @ColumnInfo("title") val title: String,
    @ColumnInfo("desc") val desc: String,
    @ColumnInfo("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
