package com.example.mvphierarquiaapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mvphierarquiaapp.viewmodel.UserViewModel

@Composable
fun LoginScreen(navController: NavHostController, viewModel: UserViewModel) {
    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var erro by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Login", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))
            TextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuário") }
            )
            Spacer(Modifier.height(8.dp))
            TextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(Modifier.height(16.dp))
            Button(onClick = {
                if (viewModel.login(usuario, senha)) {
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }
                } else {
                    erro = true
                }
            }) {
                Text("Entrar")
            }
            if (erro) {
                Spacer(Modifier.height(8.dp))
                Text("Usuário ou senha inválidos.", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}