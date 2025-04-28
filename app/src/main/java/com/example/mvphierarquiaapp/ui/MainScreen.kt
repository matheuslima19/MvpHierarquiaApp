package com.example.mvphierarquiaapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mvphierarquiaapp.viewmodel.UserViewModel

@Composable
fun MainScreen(navController: NavHostController, viewModel: UserViewModel) {
    val subordinados = viewModel.getSubordinadosDiretos()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Subordinados", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))

            LazyColumn {
                items(subordinados.size) { index ->
                    val user = subordinados[index]
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Nome: ${user.nome}")
                            Text("Último Acesso: ${user.ultimoAcesso}")
                            Spacer(Modifier.height(8.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Button(
                                 onClick = { navController.navigate("chat/${user.id}") }
                                ) {
                                    Text("Chat")
                                }
                                Button(
                                 onClick = { navController.navigate("location/${user.id}") }
                                ) {
                                    Text("Localização")
                                }
                            }
                        }
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("register") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Adicionar Subordinado")
            }
        }
    }
}