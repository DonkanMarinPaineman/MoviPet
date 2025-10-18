package com.example.movipet.viewmodel

import com.example.movipet.model.*
import com.example.movipet.model.enums.*


data class ViajeEstadoUI(
    val origen: Ubicacion? = null,
    val destino: Ubicacion? = null,
    val tipoMascota: TipoMascota? = null,
    val tipoVehiculo: TipoVehiculo? = null,
    val precioEstimado: Double? = null,
    val buscando: Boolean = false,
    val conductores: List<Pair<Conductor, Vehiculo>> = emptyList(),
    val viajeAsignado: Viaje? = null
)