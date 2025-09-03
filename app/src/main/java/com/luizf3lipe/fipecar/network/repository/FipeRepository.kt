package com.luizf3lipe.fipecar.network.repository

import com.luizf3lipe.fipecar.domain.model.Anos
import com.luizf3lipe.fipecar.domain.model.Marca
import com.luizf3lipe.fipecar.domain.model.Modelo
import com.luizf3lipe.fipecar.domain.model.Veiculo
import com.luizf3lipe.fipecar.domain.repository.IFipeRepository
import com.luizf3lipe.fipecar.network.FipeClient

class FipeRepository(
    private val client: FipeClient
): IFipeRepository {
    override suspend fun getMarcas(): List<Marca> {
        return client.getMarcas().map { marca ->
            Marca(
                codigo = marca.codigo,
                nome = marca.nome
            )
        }
    }

    override suspend fun getModelos(codMarca: String): List<Modelo> {
        return client.getModelos(codMarca).modelos.map { mod ->
            Modelo(
                codigo = mod.codigo,
                nome = mod.nome
            )
        }
    }

    override suspend fun getAnos(codMarca: String, codModelo: String): List<Anos> {
        return client.getAnos(codMarca, codModelo).map { ano ->
            Anos(
                codigo = ano.codigo,
                nome = ano.nome
            )
        }
    }

    override suspend fun getVeiculo(codMarca: String, codModelo: String, codAno: String): Veiculo {
        return client.getInfoVeiculo(codMarca, codModelo, codAno).let { veic ->
            Veiculo(
                tipoVeiculo = veic.TipoVeiculo,
                valor = veic.Valor,
                marca = veic.Marca,
                modelo = veic.Modelo,
                anoModelo = veic.AnoModelo,
                combustivel = veic.Combustivel,
                codigoFipe = veic.CodigoFipe,
                mesReferencia = veic.MesReferencia,
                siglaCombustivel = veic.SiglaCombustivel
            )
        }
    }
}