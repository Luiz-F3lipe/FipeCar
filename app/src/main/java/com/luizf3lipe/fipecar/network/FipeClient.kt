package com.luizf3lipe.fipecar.network

import com.luizf3lipe.fipecar.network.dtos.AnosResponseDto
import com.luizf3lipe.fipecar.network.dtos.InfoVeiculoResponseDto
import com.luizf3lipe.fipecar.network.dtos.MarcasResonseDto
import com.luizf3lipe.fipecar.network.dtos.ModelosResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class FipeClient {
    private val _baseUrl = "https://parallelum.com.br/fipe/api/v1/carros"
    private val client = HttpClient(Android) {
        install(Logging)
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getMarcas(): List<MarcasResonseDto> {
        return client.get("$_baseUrl/marcas").body()
    }

    suspend fun getModelos(codMarca: String): ModelosResponseDto {
        return client.get("$_baseUrl/marcas/$codMarca/modelos").body()
    }

    suspend fun getAnos(codMarca: String, codModelo: Int): List<AnosResponseDto> {
        return client.get("$_baseUrl/marcas/$codMarca/modelos/$codModelo/anos").body()
    }

    suspend fun getInfoVeiculo(codMarca: String, codModelo: String, codAno: String): InfoVeiculoResponseDto {
        return client.get("$_baseUrl/marcas/$codMarca/modelos/$codModelo/anos/$codAno").body()
    }
}