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
    val viewModel = UserViewModel() // Cria uma instância mockada no navigation

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
        composable("chat") {
            ChatScreen(navController = navController, userId = 1, viewModel = viewModel)
        }
        composable("location") {
            LocationScreen(navController = navController, userId = 1, viewModel = viewModel)
        }
//        composable("chat/{userId}") { backStackEntry ->
//            val userId = backStackEntry.arguments?.getString("userId")
//            // Aqui você pode passar o userId para a tela de chat
//            // ChatScreen(userId = userId, navController = navController)
//        }
//        composable("location/{userId}") { backStackEntry ->
//            val userId = backStackEntry.arguments?.getString("userId")
//            // Aqui você pode passar o userId para a tela de localização
//            // LocationScreen(userId = userId, navController = navController)
//        }
    }
}