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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TelaInicio(irParaMenu: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(26, 15, 38)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Spacer(modifier = Modifier.height(30.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "N",
                        color = Color(229, 9, 20),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Inicio",
                        color = Color(255, 255, 255),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row {
                    Filtro("Series")
                    Spacer(modifier = Modifier.width(10.dp))
                    Filtro("Filmes")
                    Spacer(modifier = Modifier.width(10.dp))
                    Filtro("Categorias")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Surface(
                    modifier = Modifier.fillMaxWidth().height(280.dp),
                    shape = RoundedCornerShape(6.dp),
                    color = Color(123, 74, 158)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(1.dp))

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "GRAND THEFT AUTO",
                                color = Color(255, 255, 255),
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "UM OLHAR ESTENDIDO",
                                color = Color(255, 255, 255),
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Estreia exclusiva",
                                color = Color(255, 255, 255),
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                BotaoBanner("Assistir", Color(255, 255, 255), Color.Black)
                                BotaoBanner("+ Minha lista", Color(0, 0, 0, 85), Color(255, 255, 255))
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Series dramaticas",
                    color = Color(255, 255, 255),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Cartaz("OUTER BANKS", Color(62, 92, 118), true)
                    Cartaz("O MENTALISTA", Color(140, 28, 19), true)
                    Cartaz("THE VAMPIRE DIARIES", Color(46, 42, 79), false)
                }
            }

            BarraInferior(irParaMenu)
        }
    }
}

@Composable
fun Filtro(texto: String) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = Color(255, 255, 255, 51)
    ) {
        Text(
            text = texto,
            color = Color(255, 255, 255),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun BotaoBanner(texto: String, cor: Color, corTexto: Color) {
    Surface(
        modifier = Modifier.width(140.dp),
        shape = RoundedCornerShape(6.dp),
        color = cor
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = texto,
                color = corTexto,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun Cartaz(titulo: String, cor: Color, top10: Boolean) {
    Surface(
        modifier = Modifier.width(100.dp).height(140.dp),
        shape = RoundedCornerShape(4.dp),
        color = cor
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            if (top10) {
                Surface(color = Color(229, 9, 20)) {
                    Text(
                        text = "TOP 10",
                        color = Color(255, 255, 255),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(2.dp)
                    )
                }
            } else {
                Spacer(modifier = Modifier.height(1.dp))
            }

            Text(
                text = titulo,
                color = Color(255, 255, 255),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(6.dp)
            )
        }
    }
}

@Composable
fun BarraInferior(irParaMenu: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(30.dp),
        color = Color(43, 43, 43)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(24.dp),
                color = Color(255, 255, 255)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Inicio")
                    Text(
                        text = "Inicio",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Text(
                text = "Clipes",
                color = Color(179, 179, 179),
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Buscar",
                color = Color(179, 179, 179),
                style = MaterialTheme.typography.bodyMedium
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable(onClick = { irParaMenu() })
            ) {
                Avatar("L", Color(232, 176, 4), 24)
                Text(
                    text = "Minha Netflix",
                    color = Color(255, 255, 255),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
