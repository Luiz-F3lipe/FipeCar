package com.luizf3lipe.fipecar.screens.anos

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luizf3lipe.fipecar.domain.model.Anos
import com.luizf3lipe.fipecar.domain.repository.IFipeRepository
import kotlinx.coroutines.launch

class AnosViewModel(
    private val repository: IFipeRepository
): ViewModel() {
    val allAnos = mutableStateListOf<Anos>();
    val anos = mutableStateListOf<Anos>();

    fun carregarAnos(codigoMarca: String, codigoModelo: Int) {
        viewModelScope.launch {
            try {
                val lista = repository.getAnos(codigoMarca, codigoModelo)
                allAnos.clear()
                allAnos.addAll(lista)
                anos.clear()
                anos.addAll(lista)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun filtrarAnos(ano: String) {
        anos.clear()
        if (ano.isEmpty()) {
            anos.addAll(allAnos)
        } else {
            anos.addAll(allAnos.filter { a ->
                a.nome.uppercase().contains(ano.uppercase())
            })
        }
    }
}