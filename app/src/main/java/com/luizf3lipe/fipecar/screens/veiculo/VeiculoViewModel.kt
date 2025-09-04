package com.luizf3lipe.fipecar.screens.veiculo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luizf3lipe.fipecar.domain.model.Veiculo
import com.luizf3lipe.fipecar.domain.repository.IFipeRepository
import kotlinx.coroutines.launch

class VeiculoViewModel(
    private val repository: IFipeRepository
) : ViewModel()  {
    val veiculo = mutableStateOf<Veiculo>(Veiculo("", "", "", 0, "", "", "", 1, ""))

    fun buscarFipeVeiculo(codigoMarca: String, codigoModelo: String, anoModelo: String) {
        viewModelScope.launch {
            veiculo.value = repository.getVeiculo(codigoMarca, codigoModelo, anoModelo)
        }

    }
}