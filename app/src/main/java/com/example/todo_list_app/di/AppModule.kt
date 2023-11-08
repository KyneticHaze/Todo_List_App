package com.example.todo_list_app.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo_list_app.common.Constants.TODO_DB
import com.example.todo_list_app.data.db.TodoDatabase
import com.example.todo_list_app.data.repository.TodoRepositoryImpl
import com.example.todo_list_app.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            TODO_DB
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.todoDao)
    }

}