package com.luizf3lipe.fipecar.screens.marcas

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luizf3lipe.fipecar.domain.model.Marca
import com.luizf3lipe.fipecar.domain.repository.IFipeRepository
import kotlinx.coroutines.launch

class MarcasViewModel(
    private val repository: IFipeRepository
) : ViewModel() {
    val allMarcas = mutableStateListOf<Marca>()
    var marcas = mutableStateListOf<Marca>()
    fun carregarMarcas() {
        viewModelScope.launch {
            try {
                val lista = repository.getMarcas()
                allMarcas.clear()
                allMarcas.addAll(lista)
                marcas.clear()
                marcas.addAll(lista)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun filtrarMarca(nome: String) {
        marcas.clear()
        if (nome.isEmpty()) {
            marcas.addAll(allMarcas)
        } else {
            marcas.addAll(allMarcas.filter { marca ->
                marca.nome.uppercase().contains(nome.uppercase())
            })
        }
    }

    init {
        carregarMarcas()
    }
}