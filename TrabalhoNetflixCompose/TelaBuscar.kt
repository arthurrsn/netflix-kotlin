package com.example.netflix

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TelaBuscar(irParaInicio: () -> Unit, irParaMenu: () -> Unit) {

    var busca by remember { mutableStateOf("") }
    val listaDeFilmes = remember {
        mutableStateListOf("Bird Box", "Seven", "Clube da luta", "Interestelar", "O Poderoso Chefao", "Matrix")
    }

    Scaffold(
        bottomBar = { BarraInferior("buscar", irParaInicio, {}, irParaMenu) }
    ) { innerPadding ->

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = busca,
                    onValueChange = { busca = it },
                    placeholder = { Text("Buscar") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        modifier = Modifier.width(110.dp).height(80.dp),
                        shape = RoundedCornerShape(6.dp),
                        color = Color(122, 122, 122)
                    ) {

                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Filme Recomendado:",
                            color = Color(255, 255, 255),
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "A lista de Schindler",
                            color = Color(255, 255, 255),
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn {

                    items(listaDeFilmes) {
                        ItemFilme(it)
                    }

                }
            }
        }
    }
}

@Composable
fun ItemFilme(nomeFilme: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.width(110.dp).height(80.dp),
            shape = RoundedCornerShape(20.dp),
            color = Color(62, 92, 118)
        ) {

        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = nomeFilme,
            color = Color(255, 255, 255),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}
