package com.luizf3lipe.fipecar.screens.modelos

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
import androidx.compose.runtime.LaunchedEffect
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
import com.luizf3lipe.fipecar.components.modelos.ModeloCard
import com.luizf3lipe.fipecar.ui.theme.Typography
import com.luizf3lipe.fipecar.ui.theme.Zinc50
import com.luizf3lipe.fipecar.ui.theme.Zinc950

@Composable
fun ModelosScreen(
    navController: NavController,
    codigoMarca: String,
    viewModel: ModelosViewModel = viewModel(factory = AppViewModelFactory())
) {
    LaunchedEffect(codigoMarca) {
        viewModel.carregarModelos(codigoMarca)
    }

    val modelos = viewModel.modelos

    Column(
        modifier = Modifier
            .background(color = Zinc950)
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .windowInsetsPadding(WindowInsets.systemBars),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            navController = navController,
            title = "Modelos",
        )

        // Input um pouco mais embaixo
        SearchInput(
            placeholder = "Buscar por modelos...",
            onSearch = { search ->
                viewModel.filtrarModelos(search)
            }
        )

        Spacer(modifier = Modifier.height(4.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy((-12).dp)
        ) {
            items(modelos) { modelo ->
                ModeloCard(
                    codModelo = modelo.codigo,
                    nome = modelo.nome,
                    onSelected = {
                        navController.navigate("anos/${codigoMarca}/${modelo.codigo}")
                    }
                )
            }
        }
    }
}