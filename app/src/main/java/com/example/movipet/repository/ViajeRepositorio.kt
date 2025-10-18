package com.example.movipet.repository

import com.example.movipet.model.*
import com.example.movipet.model.enums.TipoMascota
import com.example.movipet.model.enums.TipoVehiculo

interface ViajeRepositorio {
    fun calcularPrecio(origen: Ubicacion, destino: Ubicacion, tipoMascota: TipoMascota, tipoVehiculo: TipoVehiculo): Double
    fun buscarConductores(tipoMascota: TipoMascota, tipoVehiculo: TipoVehiculo): List<Pair<Conductor, Vehiculo>>
    fun crearViaje(origen: Ubicacion, destino: Ubicacion, mascota: Mascota, tipoVehiculo: TipoVehiculo): Viaje
}