package com.luizf3lipe.fipecar.screens.marcas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.luizf3lipe.fipecar.AppViewModelFactory
import com.luizf3lipe.fipecar.components.Goback
import com.luizf3lipe.fipecar.components.Header
import com.luizf3lipe.fipecar.components.SearchInput
import com.luizf3lipe.fipecar.components.marcas.MarcaCard
import com.luizf3lipe.fipecar.ui.theme.Typography
import com.luizf3lipe.fipecar.ui.theme.Zinc50
import com.luizf3lipe.fipecar.ui.theme.Zinc950

@Composable
fun MarcasScreen(
    navController: NavController,
    viewModel: MarcasViewModel = viewModel(factory = AppViewModelFactory())
) {
    val marcas = viewModel.marcas

    Column(
        modifier = Modifier
            .background(color = Zinc950)
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .windowInsetsPadding(WindowInsets.systemBars),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header(
            navController = navController,
            title = "Marcas",
        )

        // Input um pouco mais embaixo
        SearchInput(
            placeholder = "Buscar marcas...",
            onSearch = { search ->
                viewModel.filtrarMarca(search)
            }
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Lista rolável ocupa o resto da tela
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy((-12).dp),
        ) {
            items(marcas) { marca ->
                MarcaCard(
                    marca = marca.nome,
                    codigo = marca.codigo,
                    modifier = Modifier.fillMaxWidth(),
                    onSelected = {
                        navController.navigate("modelos/${marca.codigo}")
                    }
                )
            }
        }
    }
}