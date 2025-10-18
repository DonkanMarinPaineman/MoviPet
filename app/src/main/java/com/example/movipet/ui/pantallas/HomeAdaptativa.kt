package com.example.movipet.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movipet.R
import com.example.movipet.ui.utils.ClaseAncho
import androidx.compose.ui.tooling.preview.Preview

/**
 * Pantalla adaptativa según el tamaño de pantalla (Compacta, Media, Expandida)
 */

@Composable
fun HomeAdaptativa(
    claseAncho: ClaseAncho,
    onIniciarViaje: () -> Unit
) {
    when (claseAncho) {
        ClaseAncho.COMPACTO -> HomeCompacta(onIniciarViaje)
        ClaseAncho.MEDIO -> HomeMedia(onIniciarViaje)
        ClaseAncho.EXPANDIDO -> HomeExpandida(onIniciarViaje)
    }
}

/* Pantalla Compacta (celular vertical) */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeCompacta(onIniciarViaje: () -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("MoviPet") }) }, contentWindowInsets = WindowInsets.safeDrawing
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(R.drawable.logo), contentDescription = null, Modifier.size(120.dp))
            Text("Bienvenido a MoviPet", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Transporte seguro para tus mascotas.")
            Button(onClick = onIniciarViaje, modifier = Modifier.fillMaxWidth()) { Text("Iniciar viaje") }
            OutlinedButton(onClick = { /* TODO */ }, modifier = Modifier.fillMaxWidth()) { Text("Historial de viajes") }
        }
    }
}

/* Pantalla Media (tablet pequeña / celular horizontal) */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMedia(onIniciarViaje: () -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("MoviPet") }) }, contentWindowInsets = WindowInsets.safeDrawing
    ) { padding ->
        Row(
            Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painterResource(R.drawable.logo), contentDescription = null, Modifier.size(160.dp))
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Bienvenido a MoviPet", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text("Conecta con conductores especializados en transporte animal.")
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(onClick = onIniciarViaje, modifier = Modifier.weight(1f)) { Text("Iniciar viaje") }
                    OutlinedButton(onClick = { /* TODO */ }, modifier = Modifier.weight(1f)) { Text("Historial") }
                }
            }
        }
    }
}

/* Pantalla Expandida (tablet grande o escritorio) */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeExpandida(onIniciarViaje: () -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("MoviPet") }) }, contentWindowInsets = WindowInsets.safeDrawing
    ) { padding ->
        Row(
            Modifier
                .padding(padding)
                .padding(32.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Columna izquierda
            Column(
                Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painterResource(R.drawable.logo), contentDescription = null, Modifier.size(200.dp))
                Spacer(Modifier.height(16.dp))
                Text("MoviPet para pantallas amplias", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            }
            // Columna derecha
            Column(
                Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text("Reserva un transporte cómodo y seguro para tu mascota.")
                Button(onClick = onIniciarViaje, modifier = Modifier.fillMaxWidth().height(56.dp)) { Text("Iniciar viaje") }
                OutlinedButton(onClick = { /* TODO */ }, modifier = Modifier.fillMaxWidth().height(56.dp)) { Text("Historial de viajes") }
            }
            Card(
                modifier = Modifier.weight(1f),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(Modifier.padding(24.dp)) {
                    Text("Panel de información", style = MaterialTheme.typography.titleLarge)
                    Spacer(Modifier.height(8.dp))
                    Text("Aquí puedes mostrar tips, promociones o el estado de la mascota.")
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable fun Preview_Home_Compacta() { HomeCompacta({}) }

@Preview(showBackground = true, widthDp = 700, heightDp = 480)
@Composable fun Preview_Home_Media() { HomeMedia({}) }

@Preview(showBackground = true, widthDp = 1000, heightDp = 800)
@Composable fun Preview_Home_Expandida() { HomeExpandida({}) }

