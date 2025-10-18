package com.example.movipet.model


import com.example.movipet.model.enums.TipoMascota

data class Mascota(
    val id: String,
    val usuarioId: String,
    val tipo: TipoMascota,
    val nombre: String,
    val pesoKg: Double? = null
)