package com.luizf3lipe.fipecar.domain.model

data class Veiculo(
    val valor: String,
    val marca: String,
    val modelo: String,
    val anoModelo: Int,
    val combustivel: String,
    val codigoFipe: String,
    val mesReferencia: String,
    val tipoVeiculo: Int,
    val siglaCombustivel: String
)
