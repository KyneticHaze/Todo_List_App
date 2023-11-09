package com.example.todo_list_app.domain.repository

import com.example.todo_list_app.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun insertTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    suspend fun getTodoById(todoId: Int): Todo?
    fun getTodos(): Flow<List<Todo>>
}