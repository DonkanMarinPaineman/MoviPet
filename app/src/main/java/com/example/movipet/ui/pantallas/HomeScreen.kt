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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onIniciarViaje: () -> Unit) {

    // Scaffold da estructura básica a la pantalla (TopBar, contenido, etc.)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MoviPet", fontWeight = FontWeight.Bold) }
            )
        }
    ) { padding ->
        // Contenedor principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Imagen de logo (debe estar en res/drawable/logo.png)
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo MoviPet",
                modifier = Modifier.size(150.dp)
            )

            // Título principal
            Text(
                text = "Transporte seguro y rápido para tus mascotas",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            // Descripción breve
            Text(
                text = "Conecta con conductores especializados en transporte animal. " +
                        "Viaja tranquilo sabiendo que tus mascotas están en buenas manos.",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                lineHeight = 22.sp
            )

            // Botón principal
            Button(
                onClick = onIniciarViaje,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Iniciar nuevo viaje")
            }

            // Botón secundario
            OutlinedButton(
                onClick = { /* Próximamente: historial de viajes */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver historial de viajes")
            }
        }
    }
}