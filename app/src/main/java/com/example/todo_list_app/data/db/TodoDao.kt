package com.example.todo_list_app.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todo_list_app.domain.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)
    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo WHERE id = :todoId")
    suspend fun getTodoById(todoId: Int): Todo?
    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<Todo>>

}