package com.example.todo_list_app.data.repository

import com.example.todo_list_app.data.db.TodoDao
import com.example.todo_list_app.domain.model.Todo
import com.example.todo_list_app.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao: TodoDao
): TodoRepository {
    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }

    override suspend fun getTodoById(todoId: Int): Todo? {
        return dao.getTodoById(todoId)
    }

    override fun getTodos(): Flow<List<Todo>> {
        return dao.getTodos()
    }
}