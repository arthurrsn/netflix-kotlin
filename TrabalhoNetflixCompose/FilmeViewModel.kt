package com.example.netflix

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FilmeViewModel : ViewModel() {

    val filmes = mutableStateListOf(
        "Outer Banks", "O Mentalista", "The Vampire Diaries", "Bird Box",
        "Seven", "Clube da luta", "Interestelar", "Matrix"
    )

    val baixados = mutableStateListOf("Seven")

    var filmeAtual by mutableStateOf("Outer Banks")
        private set

    fun selecionar(nome: String) {
        filmeAtual = nome
    }

    fun adicionar(nome: String) {
        filmes.add(nome)
    }

    fun renomear(novoNome: String) {
        filmes.remove(filmeAtual)
        baixados.remove(filmeAtual)
        filmes.add(novoNome)
        filmeAtual = novoNome
    }

    fun excluir() {
        filmes.remove(filmeAtual)
        baixados.remove(filmeAtual)
    }

    fun baixar() {
        baixados.remove(filmeAtual)
        baixados.add(filmeAtual)
    }

    fun excluirDownload(nome: String) {
        baixados.remove(nome)
    }

}
