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
fun TelaInicio(viewModel: PerfilViewModel, irParaBuscar: () -> Unit, irParaMenu: () -> Unit, irParaFilme: () -> Unit) {
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
                        text = "Para ${viewModel.perfilAtual}",
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
                                BotaoBanner("Assistir", Color(255, 255, 255), Color.Black, Modifier.width(140.dp))
                                BotaoBanner("+ Minha lista", Color(0, 0, 0, 85), Color(255, 255, 255), Modifier.width(140.dp))
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
                    Cartaz("OUTER BANKS", Color(62, 92, 118), "TOP 10", irParaFilme)
                    Cartaz("O MENTALISTA", Color(140, 28, 19), "TOP 10", {})
                    Cartaz("THE VAMPIRE DIARIES", Color(46, 42, 79), "", {})
                }
            }

            BarraInferior("inicio", {}, irParaBuscar, irParaMenu)
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
fun BotaoBanner(texto: String, cor: Color, corTexto: Color, modifier: Modifier) {
    Surface(
        modifier = modifier,
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
fun Cartaz(titulo: String, cor: Color, selo: String, aoClicar: () -> Unit) {
    Surface(
        modifier = Modifier
            .width(108.dp)
            .height(140.dp)
            .clickable(onClick = { aoClicar() }),
        shape = RoundedCornerShape(4.dp),
        color = cor
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            if (selo == "TOP 10") {
                Surface(color = Color(229, 9, 20)) {
                    Text(
                        text = selo,
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
                modifier = Modifier.padding(3.dp)
            )
        }
    }
}

@Composable
fun ItemBarra(texto: String, tela: String, telaAtual: String, aoClicar: () -> Unit) {
    Surface(
        modifier = Modifier.clickable(onClick = { aoClicar() }),
        shape = RoundedCornerShape(24.dp),
        color = if (tela == telaAtual) Color(255, 255, 255) else Color(43, 43, 43)
    ) {
        Text(
            text = texto,
            color = if (tela == telaAtual) Color.Black else Color(179, 179, 179),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun BarraInferior(telaAtual: String, irParaInicio: () -> Unit, irParaBuscar: () -> Unit, irParaMenu: () -> Unit) {
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
            ItemBarra("Inicio", "inicio", telaAtual, irParaInicio)
            ItemBarra("Clipes", "clipes", telaAtual, {})
            ItemBarra("Buscar", "buscar", telaAtual, irParaBuscar)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable(onClick = { irParaMenu() })
            ) {
                Avatar(Color(232, 176, 4), Modifier.size(24.dp))
                Text(
                    text = "Minha Netflix",
                    color = Color(255, 255, 255),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
