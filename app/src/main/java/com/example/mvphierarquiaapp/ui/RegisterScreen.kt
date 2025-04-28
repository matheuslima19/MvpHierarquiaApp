package com.example.mvphierarquiaapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mvphierarquiaapp.viewmodel.UserViewModel

@Composable
fun RegisterScreen(navController: NavHostController, viewModel: UserViewModel) {
    var nome by remember { mutableStateOf("") }
    var podeCadastrar by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Cadastrar Subordinado", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))

            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome do Subordinado") }
            )
            Spacer(Modifier.height(8.dp))

            Row {
                Text("Permitir cadastro abaixo de si?")
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = podeCadastrar,
                    onCheckedChange = { podeCadastrar = it }
                )
            }
            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    val subordinado = viewModel.adicionarSubordinado(nome, podeCadastrar)
                    subordinado?.let {
                        navController.popBackStack()
                    }
                }
            ) {
                Text("Cadastrar")
            }
        }
    }
}