package com.example.netflix

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TelaPerfis(irParaInicio: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier.fillMaxWidth().height(200.dp),
            color = Color(46, 125, 50)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Time("SF", Color(170, 0, 0), Color(255, 255, 255))
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "VS",
                    color = Color(255, 255, 255),
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(20.dp))
                Time("LA", Color(255, 199, 44), Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "NETFLIX",
                color = Color(229, 9, 20),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "GAMEDAY",
                color = Color(255, 255, 255),
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "NFL",
                color = Color(255, 255, 255),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Evento ao vivo - 10 de setembro, as 19h30 (horario de Brasilia)",
                color = Color(255, 255, 255),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )
            Text(
                text = "Escolha o seu perfil",
                color = Color(179, 179, 179),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Perfil("M", "Manu", Color(138, 43, 226), Modifier.size(92.dp), irParaInicio)
            Perfil("R", "Rsjr", Color(46, 158, 91), Modifier.size(92.dp), irParaInicio)
            Perfil("B", "buarda", Color(224, 70, 140), Modifier.size(92.dp), irParaInicio)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Perfil("L", "lau", Color(232, 176, 4), Modifier.size(92.dp), irParaInicio)
            Perfil("G", "Gabi", Color(74, 107, 138), Modifier.size(92.dp), irParaInicio)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    modifier = Modifier.size(92.dp),
                    shape = RoundedCornerShape(10.dp),
                    color = Color(179, 179, 179)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Editar"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Editar",
                    color = Color(179, 179, 179),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun Time(sigla: String, cor: Color, corTexto: Color) {
    Surface(
        modifier = Modifier.size(96.dp),
        shape = RoundedCornerShape(48.dp),
        color = cor
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = sigla,
                color = corTexto,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun Avatar(letra: String, cor: Color, modifier: Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        color = cor
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = letra,
                color = Color(255, 255, 255),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun Perfil(letra: String, nome: String, cor: Color, modifier: Modifier, aoClicar: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = { aoClicar() })
    ) {
        Avatar(letra, cor, modifier)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = nome,
            color = Color(179, 179, 179),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
