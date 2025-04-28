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
fun AppNavHost(navController: NavHostController, userViewModel: UserViewModel) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, userViewModel) }
        composable("main") { MainScreen(navController, userViewModel) }
        composable("register") { RegisterScreen(navController, userViewModel) }
        composable("chat/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toInt() ?: 0
            ChatScreen(userId, userViewModel)
        }
        composable("location/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toInt() ?: 0
            LocationScreen(userId, userViewModel)
        }
    }
}