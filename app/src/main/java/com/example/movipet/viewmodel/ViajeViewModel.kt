package com.example.movipet.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.movipet.model.*
import com.example.movipet.model.enums.*
import com.example.movipet.repository.ViajeRepositorio
import com.example.movipet.repository.ViajeRepositorioSimulado

class ViajeViewModel(
    private val repositorio: ViajeRepositorio = ViajeRepositorioSimulado()
) : ViewModel() {

    var estadoUI by mutableStateOf(ViajeEstadoUI())
        private set

    fun establecerOrigen(ubicacion: Ubicacion) {
        estadoUI = estadoUI.copy(origen = ubicacion)
    }

    fun establecerDestino(ubicacion: Ubicacion) {
        estadoUI = estadoUI.copy(destino = ubicacion)
    }

    fun seleccionarMascota(tipo: TipoMascota) {
        estadoUI = estadoUI.copy(tipoMascota = tipo)
    }

    fun seleccionarVehiculo(tipo: TipoVehiculo) {
        estadoUI = estadoUI.copy(tipoVehiculo = tipo)
    }

    fun cotizar() {
        val o = estadoUI.origen ?: return
        val d = estadoUI.destino ?: return
        val m = estadoUI.tipoMascota ?: return
        val v = estadoUI.tipoVehiculo ?: return
        val precio = repositorio.calcularPrecio(o, d, m, v)
        estadoUI = estadoUI.copy(precioEstimado = precio)
    }

    fun buscarConductores() {
        val m = estadoUI.tipoMascota ?: return
        val v = estadoUI.tipoVehiculo ?: return
        estadoUI = estadoUI.copy(buscando = true)
        val lista = repositorio.buscarConductores(m, v)
        estadoUI = estadoUI.copy(buscando = false, conductores = lista)
    }

    fun asignarConductor(indice: Int, mascota: Mascota) {
        val o = estadoUI.origen ?: return
        val d = estadoUI.destino ?: return
        val v = estadoUI.tipoVehiculo ?: return
        val viaje = repositorio.crearViaje(o, d, mascota, v)
        estadoUI = estadoUI.copy(viajeAsignado = viaje)
    }
}