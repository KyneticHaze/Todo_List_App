package com.example.todo_list_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todo_list_app.common.Routes
import com.example.todo_list_app.presentation.add_edit_todo.AddEditTodoScreen
import com.example.todo_list_app.presentation.todo_list.TodoListScreen
import com.example.todo_list_app.presentation.ui.theme.Todo_List_AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Todo_List_AppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Routes.TODO_LIST) {
                        composable(Routes.TODO_LIST) {
                            TodoListScreen(onNavigate = {
                                navController.navigate(it.route)
                            })
                        }

                        composable(Routes.ADD_EDIT_TODO + "?todoId={todoId}", arguments = listOf(
                            navArgument(name = "todoId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )) {
                            AddEditTodoScreen(onPopBackStack = {
                                navController.popBackStack()
                            })
                        }
                    }
                }
            }
        }
    }
}