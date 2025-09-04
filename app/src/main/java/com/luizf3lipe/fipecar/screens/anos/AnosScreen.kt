package com.luizf3lipe.fipecar.screens.anos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.luizf3lipe.fipecar.components.SearchInput
import com.luizf3lipe.fipecar.components.anos.AnosCard
import com.luizf3lipe.fipecar.ui.theme.Typography
import com.luizf3lipe.fipecar.ui.theme.Zinc50
import com.luizf3lipe.fipecar.ui.theme.Zinc950

@Composable
fun AnosScreen(
    navController: NavController,
    codigoMarca: String,
    codigoModelo: Int,
    viewModel: AnosViewModel = viewModel(factory = AppViewModelFactory())
) {
    LaunchedEffect(codigoMarca, codigoModelo) {
        viewModel.carregarAnos(codigoMarca, codigoModelo)
    }

    val anos = viewModel.anos

    Column(
        modifier = Modifier
            .background(color = Zinc950)
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 8.dp, start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Goback(onClick = { navController.popBackStack() })

            // Título no topo, centralizado
            Text(
                text = "Anos",
                style = Typography.headlineLarge,
                color = Zinc50,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                textAlign = TextAlign.Center
            )
        }

        // Input um pouco mais embaixo
        SearchInput(
            placeholder = "Buscar por modelos...",
            onSearch = { search ->
                viewModel.filtrarAnos(search)
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(bottom = 52.dp),
            verticalArrangement = Arrangement.spacedBy((-12).dp)
        ) {
            items(anos) { ano ->
                AnosCard(
                    codAno = ano.codigo,
                    nome = ano.nome,
                    onSelected = {
                        navController.navigate("veiculo/$codigoMarca/$codigoModelo/${ano.codigo}")
                    }
                )
            }
        }
    }
}