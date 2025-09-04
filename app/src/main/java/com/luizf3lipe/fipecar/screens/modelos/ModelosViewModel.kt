package com.luizf3lipe.fipecar.screens.modelos

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luizf3lipe.fipecar.domain.model.Modelo
import com.luizf3lipe.fipecar.domain.repository.IFipeRepository
import kotlinx.coroutines.launch

class ModelosViewModel(
    private val repository: IFipeRepository
) : ViewModel() {
    val allModelos = mutableStateListOf<Modelo>()
    var modelos = mutableStateListOf<Modelo>()

    fun carregarModelos(codigoMarca: String) {
        viewModelScope.launch {
            try {
                val lista = repository.getModelos(codigoMarca)
                allModelos.clear()
                allModelos.addAll(lista)
                modelos.clear()
                modelos.addAll(lista)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun filtrarModelos(nome: String) {
        modelos.clear()
        if (nome.isEmpty()) {
            modelos.addAll(allModelos)
        } else {
            modelos.addAll(allModelos.filter { modelo ->
                modelo.nome.uppercase().contains(nome.uppercase())
            })
        }
    }
}