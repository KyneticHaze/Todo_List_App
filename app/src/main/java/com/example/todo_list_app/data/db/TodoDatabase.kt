package com.example.todo_list_app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo_list_app.data.db.TodoDao
import com.example.todo_list_app.domain.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract val todoDao: TodoDao
}