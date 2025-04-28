package com.example.mvphierarquiaapp.data

data class Usuario(
    val id: Int,
    val nome: String,
    val usuario: String,
    val senha: String,
    val subordinados: MutableList<Usuario> = mutableListOf(),
    val podeCadastrar: Boolean = false,
    var ultimoAcesso: String = ""
)