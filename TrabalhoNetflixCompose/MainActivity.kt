package com.example.netflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    var tela by remember { mutableStateOf("perfis") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        if (tela == "perfis") {
            TelaPerfis(irParaInicio = { tela = "inicio" })
        }
        if (tela == "inicio") {
            TelaInicio(irParaBuscar = { tela = "buscar" }, irParaMenu = { tela = "menu" })
        }
        if (tela == "buscar") {
            TelaBuscar(irParaInicio = { tela = "inicio" }, irParaMenu = { tela = "menu" })
        }
        if (tela == "menu") {
            TelaMenu(voltar = { tela = "inicio" }, sair = { tela = "perfis" })
        }
    }
}
