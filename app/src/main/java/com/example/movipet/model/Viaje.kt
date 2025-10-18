package com.example.movipet.model

data class Viaje(
    val id: String,
    val usuarioId: String,
    val mascota: Mascota,
    val conductor: Conductor?,   // null hasta que se asigne
    val vehiculo: Vehiculo?,     // null hasta que se asigne
    val origen: Ubicacion,
    val destino: Ubicacion,
    val estado: String,          // solicitado, asignado, en_camino, completado, cancelado
    val precioEstimado: Double?  // puede ser null si no se ha cotizado
)