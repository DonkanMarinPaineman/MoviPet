package com.example.movipet.ui.utils

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

// Enumeración para representar las clases de ancho (Compacto, Medio, Expandido)
enum class ClaseAncho { COMPACTO, MEDIO, EXPANDIDO }

// Función que convierte la clase de ancho de Material3 a una clase personalizada
fun mapearClaseAncho(width: WindowWidthSizeClass): ClaseAncho = when (width) {
    WindowWidthSizeClass.Compact -> ClaseAncho.COMPACTO
    WindowWidthSizeClass.Medium -> ClaseAncho.MEDIO
    WindowWidthSizeClass.Expanded -> ClaseAncho.EXPANDIDO
    else -> ClaseAncho.COMPACTO
}


