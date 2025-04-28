package com.example.mvphierarquiaapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvphierarquiaapp.data.Usuario
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UserViewModel : ViewModel() {
    private val usuarios = mutableListOf<Usuario>()
    var usuarioLogado: Usuario? = null
        private set

    init {
        val master = Usuario(
            id = 1,
            nome = "Master User",
            usuario = "master",
            senha = "1234",
            podeCadastrar = true
        )
        usuarios.add(master)
    }

    fun login(usuario: String, senha: String): Boolean {
        val user = usuarios.find { it.usuario == usuario && it.senha == senha }
        user?.let {
            usuarioLogado = it
            it.ultimoAcesso = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
            return true
        }
        return false
    }

    fun logout() {
        usuarioLogado = null
    }

    fun adicionarSubordinado(nome: String, podeCadastrar: Boolean): Usuario? {
        val novoUsuario = Usuario(
            id = usuarios.size + 1,
            nome = nome,
            usuario = "user${usuarios.size + 1}",
            senha = (1000..9999).random().toString(),
            podeCadastrar = podeCadastrar
        )
        usuarioLogado?.subordinados?.add(novoUsuario)
        usuarios.add(novoUsuario)
        return novoUsuario
    }

    fun getSubordinadosDiretos(): List<Usuario> {
        return usuarioLogado?.subordinados ?: emptyList()
    }
}