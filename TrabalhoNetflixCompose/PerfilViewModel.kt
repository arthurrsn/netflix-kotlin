package com.example.netflix

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PerfilViewModel : ViewModel() {

    val perfis = mutableStateListOf("Manu", "Rsjr", "buarda", "lau", "Gabi")

    val nomesAdmin = mutableStateListOf(
        "admin", "admiN", "admIn", "admIN",
        "adMin", "adMiN", "adMIn", "adMIN",
        "aDmin", "aDmiN", "aDmIn", "aDmIN",
        "aDMin", "aDMiN", "aDMIn", "aDMIN",
        "Admin", "AdmiN", "AdmIn", "AdmIN",
        "AdMin", "AdMiN", "AdMIn", "AdMIN",
        "ADmin", "ADmiN", "ADmIn", "ADmIN",
        "ADMin", "ADMiN", "ADMIn", "ADMIN"
    )

    var perfilAtual by mutableStateOf("lau")
        private set

    var proximoEpisodio by mutableStateOf(true)
        private set

    var previas by mutableStateOf(true)
        private set

    fun selecionar(nome: String) {
        perfilAtual = nome
    }

    fun adicionar(nome: String) {
        perfis.add(nome)
    }

    fun renomear(novoNome: String) {
        perfis.remove(perfilAtual)
        perfis.add(novoNome)
        perfilAtual = novoNome
    }

    fun excluir() {
        perfis.remove(perfilAtual)
    }

    fun alternarProximoEpisodio() {
        proximoEpisodio = !proximoEpisodio
    }

    fun alternarPrevias() {
        previas = !previas
    }

}
