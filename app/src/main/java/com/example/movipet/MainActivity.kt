package com.example.movipet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.movipet.ui.pantallas.HomeScreen
import com.example.movipet.ui.theme.MoviPetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // Aplicamos el tema visual definido en ui.theme/
            MoviPetTheme {
                // Llamamos a la pantalla base creada en la Guía 8
                HomeScreen(
                    onIniciarViaje = {
                        // Acción del botón principal: muestra un mensaje en pantalla
                        Toast.makeText(
                            this,
                            "Funcionalidad en desarrollo 🚗🐾",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
        }
    }
}
