package com.luizf3lipe.fipecar.network.dtos

import kotlinx.serialization.Serializable

@Serializable
data class MarcasResonseDto(
    val codigo: String,
    val nome: String,
)

@Serializable
data class ModelosDto(
    val codigo: Int,
    val nome: String,
)

@Serializable
data class ModelosResponseDto(
    val modelos: List<ModelosDto>,
)

@Serializable
data class AnosResponseDto(
    val codigo: String,
    val nome: String,
)

@Serializable
data class InfoVeiculoResponseDto(
    val TipoVeiculo: Int,
    val Valor: String,
    val Marca: String,
    val Modelo: String,
    val AnoModelo: Int,
    val Combustivel: String,
    val CodigoFipe: String,
    val MesReferencia: String,
    val SiglaCombustivel: String,
)