package com.luizf3lipe.fipecar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luizf3lipe.fipecar.domain.repository.IFipeRepository
import com.luizf3lipe.fipecar.network.FipeClient
import com.luizf3lipe.fipecar.network.repository.FipeRepository
import com.luizf3lipe.fipecar.screens.anos.AnosViewModel
import com.luizf3lipe.fipecar.screens.marcas.MarcasViewModel
import com.luizf3lipe.fipecar.screens.modelos.ModelosViewModel
import com.luizf3lipe.fipecar.screens.veiculo.VeiculoViewModel

object AppModule {
    val fipeClient = FipeClient()
    val fipeRepository: IFipeRepository = FipeRepository(fipeClient)
}

@Suppress("UNCHECKED_CAST")
class AppViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MarcasViewModel::class.java) -> {
                MarcasViewModel(AppModule.fipeRepository) as T
            }
            modelClass.isAssignableFrom(ModelosViewModel::class.java) -> {
                ModelosViewModel(AppModule.fipeRepository) as T
            }
            modelClass.isAssignableFrom(AnosViewModel::class.java) -> {
                AnosViewModel(AppModule.fipeRepository) as T
            }
            modelClass.isAssignableFrom(VeiculoViewModel::class.java) -> {
                VeiculoViewModel(AppModule.fipeRepository) as T
            }
            else -> throw IllegalArgumentException("ViewModel desconhecido")
        }
    }
}