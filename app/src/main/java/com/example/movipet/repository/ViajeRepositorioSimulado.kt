package com.example.movipet.repository

import kotlin.random.Random
import com.example.movipet.model.*
import com.example.movipet.model.enums.*

class ViajeRepositorioSimulado : ViajeRepositorio {

    override fun calcularPrecio(
        origen: Ubicacion,
        destino: Ubicacion,
        tipoMascota: TipoMascota,
        tipoVehiculo: TipoVehiculo
    ): Double {
        val base = when (tipoVehiculo) {
            TipoVehiculo.AUTO_PEQUENO -> 2500.0
            TipoVehiculo.AUTO_MEDIANO -> 3000.0
            TipoVehiculo.VAN_MEDIANA -> 3500.0
            TipoVehiculo.TRANSPORTE_ESPECIAL -> 5000.0
        }
        val factorMascota = if (tipoMascota == TipoMascota.PERRO_GRANDE || tipoMascota == TipoMascota.EXOTICO) 1.2 else 1.0
        return base * factorMascota + Random.nextInt(500, 1500)
    }

    override fun buscarConductores(
        tipoMascota: TipoMascota,
        tipoVehiculo: TipoVehiculo
    ): List<Pair<Conductor, Vehiculo>> {
        val conductores = listOf(
            Conductor("c1", "María R.", 4.9),
            Conductor("c2", "Pedro L.", 4.7),
            Conductor("c3", "Ana G.", 4.8),
        )
        val vehiculos = listOf(
            Vehiculo("v1", "c1", tipoVehiculo, "Kia", "Soluto", "KX-Z123"),
            Vehiculo("v2", "c2", tipoVehiculo, "Hyundai", "H1", "LP-Z756"),
            Vehiculo("v3", "c3", tipoVehiculo, "Mercedes", "Sprinter", "MK-P932"),
        )
        return conductores.zip(vehiculos)
    }

    override fun crearViaje(
        origen: Ubicacion,
        destino: Ubicacion,
        mascota: Mascota,
        tipoVehiculo: TipoVehiculo
    ): Viaje {
        val (conductor, vehiculo) = buscarConductores(mascota.tipo, tipoVehiculo).first()
        return Viaje(
            id = "viaje-${System.currentTimeMillis()}",
            usuarioId = mascota.usuarioId,
            mascota = mascota,
            conductor = conductor,
            vehiculo = vehiculo,
            origen = origen,
            destino = destino,
            estado = "asignado",
            precioEstimado = calcularPrecio(origen, destino, mascota.tipo, tipoVehiculo)
        )
    }
}