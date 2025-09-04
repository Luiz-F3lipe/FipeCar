package com.luizf3lipe.fipecar.domain.repository

import com.luizf3lipe.fipecar.domain.model.Anos
import com.luizf3lipe.fipecar.domain.model.Marca
import com.luizf3lipe.fipecar.domain.model.Modelo
import com.luizf3lipe.fipecar.domain.model.Veiculo

interface IFipeRepository {
    suspend fun getMarcas(): List<Marca>
    suspend fun getModelos(codMarca: String): List<Modelo>
    suspend fun getAnos(codMarca: String, codModelo: Int): List<Anos>
    suspend fun getVeiculo(codMarca: String, codModelo: String, codAno: String): Veiculo
}