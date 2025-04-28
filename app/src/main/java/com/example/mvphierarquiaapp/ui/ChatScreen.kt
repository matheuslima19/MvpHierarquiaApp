package com.example.mvphierarquiaapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvphierarquiaapp.viewmodel.UserViewModel

@Composable
fun ChatScreen(userId: Int, viewModel: UserViewModel) {
    val user = viewModel.getSubordinadosDiretos().find { it.id == userId }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Chat com ${user?.nome ?: "Desconhecido"}", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))

            Text("Aqui você pode enviar mensagens... (Mockado)", style = MaterialTheme.typography.bodyMedium)

            Spacer(Modifier.height(16.dp))
            Button(onClick = { /* Mock para enviar mensagem */ }) {
                Text("Enviar Mensagem")
            }
        }
    }
}