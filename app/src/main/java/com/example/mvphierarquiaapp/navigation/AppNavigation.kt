package com.example.mvphierarquiaapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvphierarquiaapp.ui.ChatScreen
import com.example.mvphierarquiaapp.ui.LocationScreen
import com.example.mvphierarquiaapp.ui.LoginScreen
import com.example.mvphierarquiaapp.ui.MainScreen
import com.example.mvphierarquiaapp.ui.RegisterScreen
import com.example.mvphierarquiaapp.viewmodel.UserViewModel

@Composable
fun AppNavigation(navController: NavHostController) {
    val viewModel = UserViewModel()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController = navController, viewModel = viewModel)
        }
        composable("main") {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable("register") {
            RegisterScreen(navController = navController, viewModel = viewModel)
        }
        composable("chat/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toInt() ?: 0
            ChatScreen(userId, viewModel)
        }
        composable("location/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toInt() ?: 0
            LocationScreen(userId, viewModel)
        }
    }
}