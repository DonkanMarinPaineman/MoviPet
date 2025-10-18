package com.example.movipet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.movipet.ui.pantallas.HomeAdaptativa
import com.example.movipet.ui.theme.MoviPetTheme
import com.example.movipet.ui.utils.mapearClaseAncho

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class) // ← opt-in requerido
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MoviPetTheme {
                // ⬇️ Versión composable: debe ir DENTRO de setContent { }
                val wsc = calculateWindowSizeClass(activity = this@MainActivity)

                HomeAdaptativa(
                    claseAncho = mapearClaseAncho(wsc.widthSizeClass),
                    onIniciarViaje = {
                        Toast.makeText(
                            this@MainActivity,
                            "Iniciando flujo 🚗🐾",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
        }
    }
}
