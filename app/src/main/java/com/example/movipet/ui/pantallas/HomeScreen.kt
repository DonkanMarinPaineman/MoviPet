package com.example.movipet.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movipet.R

/**
 * HomeScreen - Pantalla base visual según Guía 8.
 * Usa componentes fundamentales de Jetpack Compose:
 * Text, Button, Image, Column y Row.
 * Demuestra jerarquía visual y uso del Modifier.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onIniciarViaje: () -> Unit) {

    // Scaffold crea la estructura base con TopAppBar y contenido
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MoviPet", color = MaterialTheme.colorScheme.onPrimary) },
                modifier = Modifier.background(MaterialTheme.colorScheme.primary)
            )
        }
    ) { padding ->

        // Contenedor principal de toda la pantalla
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // --- Imagen del logo ---
            Image(
                painter = painterResource(id = R.drawable.logo), // logo.png en /res/drawable/
                contentDescription = "Logo de MoviPet",
                modifier = Modifier
                    .size(150.dp)
                    .padding(top = 16.dp)
            )

            // --- Título principal ---
            Text(
                text = "Bienvenido a MoviPet 🐾",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            // --- Subtítulo descriptivo ---
            Text(
                text = "Tu app de transporte seguro para mascotas. \nViaja con confianza y cariño.",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )

            // --- Separador visual (Row con texto e ícono) ---
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("🚗", fontSize = 22.sp)
                Text(
                    text = "Transporte especializado",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            // --- Botón principal ---
            Button(
                onClick = onIniciarViaje,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Iniciar viaje", fontSize = 16.sp)
            }

            // --- Botón secundario ---
            OutlinedButton(
                onClick = { /* Acción futura */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Historial de viajes", fontSize = 16.sp)
            }

            // --- Pie de página ---
            Text(
                text = "Versión 1.0 • Proyecto educativo DSY1105",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}
