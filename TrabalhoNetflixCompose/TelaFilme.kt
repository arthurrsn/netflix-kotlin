package com.example.netflix

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TelaFilme(irParaInicio: () -> Unit, irParaBuscar: () -> Unit, irParaMenu: () -> Unit) {
    Scaffold(
        bottomBar = { BarraInferior("filme", irParaInicio, irParaBuscar, irParaMenu) }
    ) { innerPadding ->

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth().height(180.dp),
                    color = Color(62, 92, 118)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = "▶ Assistir",
                            color = Color(255, 255, 255),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Text(
                        text = "Outer Banks",
                        color = Color(255, 255, 255),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "2015",
                            color = Color(255, 255, 255),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = Color(255, 255, 255)
                        ) {
                            Text(
                                text = "14",
                                color = Color.Black,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "7 temporadas",
                            color = Color(255, 255, 255),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    BotaoBanner("▶ Assistir", Color(255, 255, 255), Color.Black, Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    BotaoBanner("↓ Baixar", Color(255, 255, 255), Color.Black, Modifier.fillMaxWidth())

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Descricao do filme",
                        color = Color(255, 255, 255),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Um grupo de adolescentes de Outer Banks sai em busca de um tesouro lendario ligado ao desaparecimento do pai de um deles.",
                        color = Color(179, 179, 179),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Recomendacoes",
                        color = Color(255, 255, 255),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Cartaz("O MENTALISTA", Color(140, 28, 19), "", {})
                        Cartaz("THE VAMPIRE DIARIES", Color(46, 42, 79), "", {})
                        Cartaz("BIRD BOX", Color(75, 96, 67), "", {})
                    }
                }
            }
        }
    }
}
