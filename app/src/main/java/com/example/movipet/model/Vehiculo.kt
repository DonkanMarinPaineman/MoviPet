package com.example.movipet.model

import com.example.movipet.model.enums.TipoVehiculo

data class Vehiculo(
    val id: String,
    val conductorId: String,
    val tipo: TipoVehiculo,
    val marca: String,
    val modelo: String,
    val patente: String
)