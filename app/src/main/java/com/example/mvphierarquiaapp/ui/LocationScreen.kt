package com.example.mvphierarquiaapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mvphierarquiaapp.viewmodel.UserViewModel

@Composable
fun LocationScreen(navController: NavHostController, userId: Int, viewModel: UserViewModel) {
    val user = viewModel.getSubordinadosDiretos().find { it.id == userId }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Localização de ${user?.nome ?: "Desconhecido"}", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))

            Text("Aqui está a localização do subordinado... (Mockado)", style = MaterialTheme.typography.bodyMedium)

            Spacer(Modifier.height(16.dp))
            Button(onClick = { /* Mock para mostrar a localização */ }) {
                Text("Mostrar Localização")
            }
        }
    }
}